package influencer.bridge.controller;

import influencer.bridge.dto.LoginRequestDto;
import influencer.bridge.dto.RegistrationDto;
import influencer.bridge.service.RegistrationService;
import influencer.bridge.utility.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/users")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping(path = "/save")
    public final ResponseEntity<SuccessResponse> saveUser(@RequestBody final RegistrationDto user){
        SuccessResponse response = registrationService.addUser(user);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping(path = "/login")
    public final Map<String, String> loginUser(@RequestBody final LoginRequestDto user){
        Map<String, String> response = registrationService.loginUser(user);
        return response;
    }

    @GetMapping(path = "/getAllUsers")
    public final List<RegistrationDto> getAllRegistration(){
        List<RegistrationDto> registrationDtos = registrationService.getAllRegistrations();
        return registrationDtos;
    }

    @GetMapping(path = "/getUser/{email}")
    public final ResponseEntity<RegistrationDto> getUserByEmail(@PathVariable("email") final String email){
        RegistrationDto registrationDto = registrationService.getUserByEmail(email);
        return ResponseEntity.of(Optional.of(registrationDto));
    }
}
