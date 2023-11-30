package bilprojekt.bilabonnement_backend.repository;

import bilprojekt.bilabonnement_backend.entity.DamageReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DamageReportRepository extends JpaRepository<DamageReport, Long> {
}