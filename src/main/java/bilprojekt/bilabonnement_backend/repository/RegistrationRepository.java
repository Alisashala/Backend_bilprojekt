package bilprojekt.bilabonnement_backend.repository;

import bilprojekt.bilabonnement_backend.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {

}
