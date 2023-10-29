package influencer.bridge.dto;

import influencer.bridge.model.Occupation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDto {

    private int userId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String userRole;
    private String email;
    private String faceBook;
    private String instagram;
    private String twitter;
    private String youtube;
    private String othersSocialMediaLink;
    private Occupation occupation;
    private String phoneNumber;
    private String Dob;
    private String address;
    private String password;
}
