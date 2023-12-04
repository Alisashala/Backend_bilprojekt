package bilprojekt.bilabonnement_backend.api;


import bilprojekt.bilabonnement_backend.entity.DamageReport;
import bilprojekt.bilabonnement_backend.repository.DamageReportRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping
@RestController


public class DamageReportController {

    private DamageReportRepository repository;

    public DamageReportController(DamageReportRepository repository) {
        this.repository = repository;
    }
/*
    @GetMapping("/api")
    public String apiDocumentation() {
        return "DamageReport API Endpoints:" +
                "\n- GET /api/damagereports: Hent alle skaderapporter" +
                "\n- GET /api/damagereports/{id}: Hent en specifik skaderapport" +
                "\n- POST /api/damagereports: Opret en ny skaderapport" +
                "\n- PUT /api/damagereports/{id}: Opdater en eksisterende skaderapport" +
                "\n- DELETE /api/damagereports/{id}: Slet en skaderapport";
    }

 */

    //GET: Hent alle skaderapporter
    @GetMapping("/api/damagereports")
    public List<DamageReport> getAllDamageReports() {
        return repository.findAll();
    }

    //GET: Hent en specifik skaderapport
    @GetMapping("/api/damagereports/{id}")
    public ResponseEntity<DamageReport> getDamageReportById(@PathVariable Long id) {
        Optional<DamageReport> damageReport = repository.findById(id);
        if (damageReport.isPresent()) {
            return ResponseEntity.ok(damageReport.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //POST: Opret en ny skaderapport
    @PostMapping("/api/damagereports")
    public DamageReport createDamageReport(@RequestBody DamageReport movie) {
        return repository.save(movie);
    }

    //PUT: Opdater en eksisterende skaderapport
    @PutMapping("/api/damagereports/{id}")
    public ResponseEntity<DamageReport> updateReport(@PathVariable Long id, @RequestBody DamageReport reportDetails) {
        Optional<DamageReport> existingDamageReport = repository.findById(id);
        if (existingDamageReport.isPresent()) {
            DamageReport updatedDamageReport = existingDamageReport.get();
            // Uncomment and modify the code to update specific fields
            // updatedDamageReport.setDamage(reportDetails.getDamage());
            return ResponseEntity.ok(repository.save(updatedDamageReport));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //DELETE: Slet en skaderapport
    @DeleteMapping("/api/damagereports/{id}")
    public ResponseEntity<?> deleteDamageReport(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
