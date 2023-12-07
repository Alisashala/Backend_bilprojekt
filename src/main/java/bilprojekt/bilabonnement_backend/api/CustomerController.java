package bilprojekt.bilabonnement_backend.api;

import bilprojekt.bilabonnement_backend.entity.Customer;
import bilprojekt.bilabonnement_backend.repository.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping
@RestController
@CrossOrigin("*")
public class CustomerController {

    private CustomerRepository repository;

    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }
    //GET ALL
    @GetMapping("/api/customers")
    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    //GET ONE
    @GetMapping("/api/customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Optional<Customer> customer = repository.findById(id);
        if (customer.isPresent()) {
            return ResponseEntity.ok(customer.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/api/customers")
    public Customer createCustomer(@RequestBody Customer customer) {
        return repository.save(customer);
    }


    @PutMapping("/api/customers/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customerDetails) {
        Optional<Customer> existingCustomer = repository.findById(id);
        if (existingCustomer.isPresent()) {
            Customer updatedCustomer = existingCustomer.get();
            updatedCustomer.setCpr(customerDetails.getCpr());
            updatedCustomer.setEmail(customerDetails.getEmail());
            updatedCustomer.setFullName(customerDetails.getFullName());
            updatedCustomer.setRegion(customerDetails.getRegion());
            return ResponseEntity.ok(repository.save(updatedCustomer));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/api/customers/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
