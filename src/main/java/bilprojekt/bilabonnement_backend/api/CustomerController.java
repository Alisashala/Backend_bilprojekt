package bilprojekt.bilabonnement_backend.api;

import bilprojekt.bilabonnement_backend.entity.Customer;
import bilprojekt.bilabonnement_backend.entity.Registration;
import bilprojekt.bilabonnement_backend.repository.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//Angiver at klassen fungerer som controller, og skal behandle HTTP-anmodninger
@RequestMapping
@RestController
@CrossOrigin("*")
public class CustomerController {

    // Bruges til at udføre databaseoperationer relateret til customer entiteten
    private CustomerRepository repository;
    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }


    //GET: retunerer en liste over alle lejeaftaler (agreements)
    @GetMapping("/api/customers")
    public List<Customer> getAllCustomers() {
        //repository.findAll kalder metoden på CustomerRepository, som har ansvaret som at hende alle lejeaftaler fra DB
        return repository.findAll();
    }


    //GET: retunerer en specifik lejeaftale (agreement),
    @GetMapping("/api/customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        //Bruger CustomerRepository til at søge efter en lejeaftale i DB - Optional = lejaftalen kan enten være til stede eller ikke.
        Optional<Customer> customer = repository.findById(id);
        //Tjekker om Optional<Customer> customer indeholder en værdi (ikke er null)
        if (customer.isPresent()) {
            //Returnerer en OK respons som bekræftelse
            return ResponseEntity.ok(customer.get());
        } else {
            //Returnerer en NOT FOUND respons hvis ikke fundet
            return ResponseEntity.notFound().build();
        }
    }


    //POST: opretter en ny lejeaftale (agreement) og gemmeer i DB
    @PostMapping("/api/customers")
    public Customer createCustomer(@RequestBody Customer customer) {
        //Den oprettede lejeaftale gemmes ved hjælp af CustomerRepositoyets .save metode.
        return repository.save(customer);
    }


    //PUT: opdaterer en eksisterende lejeaftele baseret på ID'et
    @PutMapping("/api/customers/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customerDetails) {
        //Bruger CustomerRepository til at søge efter en specifik lejeaftale i DB - Optional = lejaftalen kan enten være til stede eller ikke.
        Optional<Customer> existingCustomer = repository.findById(id);
        //Tjekker om lejeaftalen med det specifikke ID eskisterer i DB
        if (existingCustomer.isPresent()) {
            //Henter den lejeaftelen fra Optional, og odaterer dens attributer med nye oplysninger
            Customer updatedCustomer = existingCustomer.get();
            updatedCustomer.setCpr(customerDetails.getCpr());
            updatedCustomer.setEmail(customerDetails.getEmail());
            updatedCustomer.setFullName(customerDetails.getFullName());
            updatedCustomer.setRegion(customerDetails.getRegion());
            updatedCustomer.setPrice(customerDetails.getPrice());
            updatedCustomer.setKml(customerDetails.getKml());
            updatedCustomer.setBraendstof(customerDetails.getBraendstof());
            updatedCustomer.setModel(customerDetails.getModel());
            updatedCustomer.setBrand(updatedCustomer.getBrand());
            //Gemmer den opdaterede lejeaftele i DB ved hjælp af CustomerRepositoryets .save metode
            return ResponseEntity.ok(repository.save(updatedCustomer));
        } else {
            //Ellers retuneres en fejlrespons, hvis den ikke findes i DB
            return ResponseEntity.notFound().build();
        }
    }

    //DELETE: slepper en eksisterende lejeaftale baseret på ID'et
    @DeleteMapping("/api/customers/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        //Tjekker om lejeaftalen med ID'et eksisterer i DB
        if (repository.existsById(id)) {
            //Sletter lejeaftalen ved hjælp af CustomerRepositoryets .deleteById
            repository.deleteById(id);
            //Returnerer en OK respons som bekræftelse
            return ResponseEntity.ok().build();
        } else {
            //Returnerer en 404 NOT FOUND respons, hvis fejl
            return ResponseEntity.notFound().build();
        }
    }

}
