package bilprojekt.bilabonnement_backend.api;

import bilprojekt.bilabonnement_backend.entity.Customer;
import bilprojekt.bilabonnement_backend.entity.DamageReport;
import bilprojekt.bilabonnement_backend.repository.DamageReportRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//Angiver at klassen fungerer som controller, og skal behandle HTTP-anmodninger
@RequestMapping
@RestController
@CrossOrigin("*")
public class DamageReportController {

    // Bruges til at udføre databaseoperationer relateret til DamageReport entiteten
    private final DamageReportRepository repository;
    public DamageReportController(DamageReportRepository repository) {
        this.repository = repository;
    }


    //GET: retunerer en liste over alle skade rapporter
    @GetMapping("/api/damagereports")
    public List<DamageReport> getAllDamageReports() {
        //repository.findAll kalder metoden på DamageReportRepository, som har ansvaret som at hende alle skade rapporter fra DB
        return repository.findAll();
    }


    //GET: retunerer en specifik skade rapport
    @GetMapping("/api/damagereports/{id}")
    public ResponseEntity<DamageReport> getDamageReportById(@PathVariable Long id) {
        //Bruger DamageReportRepository til at søge efter en skade rapport i DB - Optional = skade rapprten kan enten være til stede eller ikke.
        Optional<DamageReport> damageReport = repository.findById(id);
        //Tjekker om Optional<DamageReport> damagereport indeholder en værdi (ikke er null)
        if (damageReport.isPresent()) {
            //Returnerer en OK respons som bekræftelse
            return ResponseEntity.ok(damageReport.get());
        } else {
            //Returnerer en NOT FOUND respons hvis ikke fundet
            return ResponseEntity.notFound().build();
        }
    }


    //POST: opretter en ny skade rapport og gemmer i DB
    @PostMapping("/api/damagereports")
    public DamageReport createDamageReport(@RequestBody DamageReport damageReport) {
        //Den oprettede skade rapport gemmes ved hjælp af DamageReportRepositoryets .save metode.
        return repository.save(damageReport);
    }


    //PUT: opdaterer en eksisterende skade rapport gennem ID'et
    @PutMapping("/api/damagereports/{id}")
    public ResponseEntity<DamageReport> updateReport(@PathVariable Long id, @RequestBody DamageReport reportDetails) {
        //Bruger DamageReportRepository til at søge efter en specifik skade rapport i DB - Optional = skade rapporten kan enten være til stede eller ikke.
        Optional<DamageReport> existingDamageReport = repository.findById(id);
        //Tjekker om skade rapporten med det specifikke ID eskisterer i DB
        if (existingDamageReport.isPresent()) {
            //Henter den skade rapport fra Optional, og odaterer dens attributer med nye oplysninger
            DamageReport updatedDamageReport = existingDamageReport.get();
            updatedDamageReport.setDamageLevel(reportDetails.getDamageLevel());
            updatedDamageReport.setDamageType(reportDetails.getDamageType());
            updatedDamageReport.setDamageDescription(reportDetails.getDamageDescription());
            updatedDamageReport.setModel(reportDetails.getModel());
            updatedDamageReport.setBrand(reportDetails.getBrand());
            updatedDamageReport.setDamageCost(reportDetails.getDamageCost());
            //Gemmer den opdaterede skade rapport i DB ved hjælp af DamageReportRepositoryets .save metode
            return ResponseEntity.ok(repository.save(updatedDamageReport));
        } else {
            //Ellers retuneres en fejlrespons, hvis den ikke findes i DB
            return ResponseEntity.notFound().build();
        }
    }


    //DELETE: sletter en eksisterende skade rapport baseret på ID'et
    @DeleteMapping("/api/damagereports/{id}")
    public ResponseEntity<?> deleteDamageReport(@PathVariable Long id) {
        //Tjekker om skade rapporten med ID'et eksisterer i DB
        if (repository.existsById(id)) {
            //Sletter skade rapporten ved hjælp af DamageReportRepositoryets .deleteById metode
            repository.deleteById(id);
            //Returnerer en OK respons som bekræftelse
            return ResponseEntity.ok().build();
        } else {
            //Returnerer en 404 NOT FOUND respons, hvis fejl
            return ResponseEntity.notFound().build();
        }
    }
}