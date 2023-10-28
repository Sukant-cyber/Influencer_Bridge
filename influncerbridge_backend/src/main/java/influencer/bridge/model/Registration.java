package influencer.bridge.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Registration {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int userId;

    @Column(nullable = false)
    String firstName;

    @Column(nullable = false)
    String middleName;

    @Column(nullable = false)
    String lastName;

    @Column(nullable = false)
    private String userRole;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String faceBook;

    @Column(nullable = false)
    private String instagram;

    @Column(nullable = false)
    private String twitter;

    @Column(nullable = false)
    private String youtube;

    @Column(nullable = false)
    private String othersSocialMediaLink;

    @Enumerated(EnumType.STRING)
    private Occupation occupation;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String Dob;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String password;

}
