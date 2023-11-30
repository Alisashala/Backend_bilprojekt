package bilprojekt.bilabonnement_backend.api;


import bilprojekt.bilabonnement_backend.entity.Registration;
import bilprojekt.bilabonnement_backend.repository.RegistrationRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping
public class RegistrationController {

    private RegistrationRepository repository;

    public RegistrationController(RegistrationRepository repository) {
        this.repository = repository;
    }

        @GetMapping("/api")
        public String apiDocumentation() {
            return "Registration API Endpoints:" +
                    "\n- GET /api/agreements: hent alle lejeaftaler" +
                    "\n- GET /api/agreement/{id}: hent en specifik lejeaftale" +
                    "\n- POST /api/agreements: opret en ny lejeaftale" +
                    "\n- PUT /api/agreements/{id}: opdater en eksisterende lejeatale" +
                    "\n- DELETE /api/agreements/{id}: slet en lejeaftale";

    }

    //GET: Hent alle lejeaftaler
    @GetMapping("/api/agreements")
    public List<Registration> getAllAgreements() {
        return repository.findAll();
    }

    //GET: Hent en specifik lejeaftale
    @GetMapping("/api/agreement/{id}")
    public ResponseEntity<Registration> getAgreementById(@PathVariable Long id) {
        Optional<Registration> registration = repository.findById(id);
        if (registration.isPresent()) {
            return ResponseEntity.ok(registration.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    //POST: Opret en ny lejeaftale
    @PostMapping("/api/agreements")
    public Registration createAgreement(@RequestBody Registration registration) {
        return repository.save(registration);
    }

    //PUT: Opdater en eksistserende lejeaftale
    @PutMapping("/api/agreements/{id}")
    public ResponseEntity<Registration> updateAgreement(@PathVariable Long id, @RequestBody Registration registrationDetails) {
        Optional<Registration> existingAgreement = repository.findById(id);
        if (existingAgreement.isPresent()) {
            Registration updatedAgreement = existingAgreement.get();
            updatedAgreement.setEmail(registrationDetails.getEmail());
            return ResponseEntity.ok(repository.save(updatedAgreement));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //DELETE: Slet en lejeaftale
    @DeleteMapping("/api/agreements/{id}")
    public ResponseEntity<?> deleteAgreement(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
