package influencer.bridge.service.serviceImplemantation;


import influencer.bridge.dto.LoginRequestDto;
import influencer.bridge.dto.RegistrationDto;
import influencer.bridge.exception.AlreadyExistsException;
import influencer.bridge.exception.ResourceNotFoundException;
import influencer.bridge.exception.WrongCredentialsException;
import influencer.bridge.model.Registration;
import influencer.bridge.repository.RegistrationRepository;
import influencer.bridge.service.RegistrationService;
import influencer.bridge.utility.SuccessResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    /**
     * @param registrationDto
     * @return
     */
    @Override
    public SuccessResponse addUser(RegistrationDto registrationDto) {


        if (registrationRepository.findByEmail(registrationDto.getEmail()).isPresent()) {
            throw new AlreadyExistsException("Email already exists");
        }

        // Convert RegistrationDto to Registration entity
        Registration registration = this.registrationDtoToRegistration(registrationDto);

        String encodedPassword = passwordEncoder.encode(registration.getPassword());

        Registration newRegistration = new Registration(
                0,
                registration.getFirstName(),
                registration.getMiddleName(),
                registration.getLastName(),
                "user",
                registration.getEmail(),
                registration.getFaceBook(),
                registration.getInstagram(),
                registration.getTwitter(),
                registration.getYoutube(),
                registration.getOthersSocialMediaLink(),
                registration.getOccupation(),
                registration.getPhoneNumber(),
                registration.getDob(),
                registration.getAddress(),
                encodedPassword
        );
        // Save the registration entity to the repository
        registrationRepository.save(newRegistration);

        return new SuccessResponse(HttpStatus.CREATED.value(),"User added Successfully");
    }

    /**
     * @return
     */
    @Override
    public List<RegistrationDto> getAllRegistrations() {
        List<Registration> registrations = this.registrationRepository.findAll();

        List<RegistrationDto> registrationDtos = registrations.stream().map(registration ->
                this.registrationToRegistrationDto(registration))
                .collect(Collectors.toList());
        return registrationDtos;
    }

    /**
     * @param loginRequestDto
     * @return
     */
    @Override
    public Map<String, String> loginUser(LoginRequestDto loginRequestDto) {
        Map<String, String> response = new HashMap<>();

        String email = loginRequestDto.getEmail();
        String password = loginRequestDto.getPassword();

        Registration foundRegistration = registrationRepository.getByEmail(email);

        if (foundRegistration == null) {
            // User not found, throw a ResourceNotFoundException
            throw new ResourceNotFoundException("User with email " + email + " not found");
        }

        if (passwordEncoder.matches(password, foundRegistration.getPassword())) {
            // Password matches, provide a successful login response
            response.put("message", "Login Successful");
            response.put("status", "true");
            response.put("email", foundRegistration.getEmail());
        } else {
            // Password does not match, throw a WrongCredentialsException
            throw new WrongCredentialsException("Invalid email or password");
        }

        return response;
    }


    /**
     * @param email
     * @return
     */
    @Override
    public RegistrationDto getUserByEmail(String email) {
        Optional<Registration> existingUser = registrationRepository.findByEmail(email);
        if (existingUser.isPresent()){
            RegistrationDto user = registrationToRegistrationDto(existingUser.get());
            return user;
        }else {
            return null;
        }
    }

    private Registration registrationDtoToRegistration(final RegistrationDto registrationDto){

        Registration registration = this.modelMapper.map(registrationDto, Registration.class);
        return registration;
    }

    private RegistrationDto registrationToRegistrationDto(final Registration registration){

        RegistrationDto registrationDto = this.modelMapper.map(registration, RegistrationDto.class);
        return registrationDto;
    }
}
