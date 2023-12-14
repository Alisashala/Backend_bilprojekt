package bilprojekt.bilabonnement_backend.repository;

import bilprojekt.bilabonnement_backend.entity.DamageReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DamageReportRepository extends JpaRepository<DamageReport, Long> {
    // Dette interface arver metoder fra JpaRepository, og derfor er ingen yderligere implementering nødvendig.
    // Spring Data JPA genererer automatisk implementeringen baseret på metodenavne.
}