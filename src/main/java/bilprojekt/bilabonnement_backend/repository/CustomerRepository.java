package bilprojekt.bilabonnement_backend.repository;

import bilprojekt.bilabonnement_backend.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}