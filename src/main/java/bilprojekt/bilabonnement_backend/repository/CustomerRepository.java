package bilprojekt.bilabonnement_backend.repository;

import bilprojekt.bilabonnement_backend.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Dette interface arver metoder fra JpaRepository, og derfor er ingen yderligere implementering nødvendig.
    // Spring Data JPA genererer automatisk implementeringen baseret på metodenavne.
}