package influencer.bridge.service;

import influencer.bridge.dto.LoginRequestDto;
import influencer.bridge.dto.RegistrationDto;
import influencer.bridge.utility.SuccessResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface RegistrationService {

    SuccessResponse addUser(RegistrationDto registrationDto);

    List<RegistrationDto> getAllRegistrations();

    Map<String, String> loginUser(LoginRequestDto loginRequestDto);

    RegistrationDto getUserByEmail(String email);

}
