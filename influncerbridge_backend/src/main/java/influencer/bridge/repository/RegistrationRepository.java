package influencer.bridge.repository;

import influencer.bridge.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegistrationRepository extends JpaRepository<Registration, Integer> {

    Registration getByEmail(String email);

    Optional<Registration> findByEmail(String email);

    Optional<Registration> findByEmailAndPassword(String email, String password);
}
