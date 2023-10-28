package influencer.bridge.service.serviceImplemantation;


import influencer.bridge.dto.LoginRequestDto;
import influencer.bridge.dto.RegistrationDto;
import influencer.bridge.model.Registration;
import influencer.bridge.repository.RegistrationRepository;
import influencer.bridge.service.RegistrationService;
import influencer.bridge.utility.SuccessResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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


    /**
     * @param registrationDto
     * @return
     */
    @Override
    public SuccessResponse addUser(RegistrationDto registrationDto) {
        // Convert RegistrationDto to Registration entity
        Registration registration = this.registrationDtoToRegistration(registrationDto);

        // Set the userRole directly
        registration.setUserRole("user");

        // Save the registration entity to the repository
        registrationRepository.save(registration);

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

        Registration foundRegistration = registrationRepository.getByEmail(loginRequestDto.getEmail());
        String email = loginRequestDto.getEmail();
        String password = loginRequestDto.getPassword();

        Optional<Registration> registrationOptional = registrationRepository.findByEmailAndPassword(email, password);

        if (registrationOptional.isPresent()) {
           response.put("message","Login Successful");
           response.put("status","true");
           response.put("email",foundRegistration.getEmail());
        } else {
            // User not found, return an error message
            return Map.of("message", "Login failed. Invalid email or password.");
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
