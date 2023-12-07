package bilprojekt.bilabonnement_backend.api;

import bilprojekt.bilabonnement_backend.entity.DamageReport;
import bilprojekt.bilabonnement_backend.repository.DamageReportRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class DamageReportController {

    private final DamageReportRepository repository;

    public DamageReportController(DamageReportRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/damagereports")
    public List<DamageReport> getAllDamageReports() {
        return repository.findAll();
    }

    @GetMapping("/damagereports/{id}")
    public ResponseEntity<DamageReport> getDamageReportById(@PathVariable Long id) {
        Optional<DamageReport> damageReport = repository.findById(id);
        return damageReport.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/damagereports")
    public DamageReport createDamageReport(@RequestBody DamageReport damageReport) {
        return repository.save(damageReport);
    }

    @PutMapping("/damagereports/{id}")
    public ResponseEntity<DamageReport> updateReport(@PathVariable Long id, @RequestBody DamageReport reportDetails) {
        return repository.findById(id)
                .map(existingDamageReport -> {
                    // Uncomment and modify the code to update specific fields
                    // existingDamageReport.setDamage(reportDetails.getDamage());
                    return ResponseEntity.ok(repository.save(existingDamageReport));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/damagereports/{id}")
    public ResponseEntity<?> deleteDamageReport(@PathVariable Long id) {
        return repository.findById(id)
                .map(existingDamageReport -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
