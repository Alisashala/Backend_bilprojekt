package bilprojekt.bilabonnement_backend.api;

import bilprojekt.bilabonnement_backend.entity.Customer;
import bilprojekt.bilabonnement_backend.entity.DamageReport;
import bilprojekt.bilabonnement_backend.repository.DamageReportRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping
@RestController
@CrossOrigin("*")
public class DamageReportController {

    private final DamageReportRepository repository;

    public DamageReportController(DamageReportRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/api/damagereports")
    public List<DamageReport> getAllDamageReports() {
        return repository.findAll();
    }

    @GetMapping("/api/damagereports/{id}")
    public ResponseEntity<DamageReport> getDamageReportById(@PathVariable Long id) {
        Optional<DamageReport> damageReport = repository.findById(id);
        return damageReport.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/api/damagereports")
    public DamageReport createDamageReport(@RequestBody DamageReport damageReport) {
        return repository.save(damageReport);
    }

    @PutMapping("/api/damagereports/{id}")
    public ResponseEntity<DamageReport> updateReport(@PathVariable Long id, @RequestBody DamageReport reportDetails) {
        Optional<DamageReport> existingDamageReport = repository.findById(id);
        if (existingDamageReport.isPresent()) {
            DamageReport updatedDamageReport = existingDamageReport.get();
            updatedDamageReport.setDamageLevel(reportDetails.getDamageLevel());
            updatedDamageReport.setDamageType(reportDetails.getDamageType());
            updatedDamageReport.setDamageDescription(reportDetails.getDamageDescription());
            updatedDamageReport.setModel(reportDetails.getModel());
            updatedDamageReport.setBrand(reportDetails.getBrand());
            updatedDamageReport.setDamageCost(reportDetails.getDamageCost());
            return ResponseEntity.ok(repository.save(updatedDamageReport));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/api/damagereports/{id}")
    public ResponseEntity<?> deleteDamageReport(@PathVariable Long id) {
        return repository.findById(id)
                .map(existingDamageReport -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}