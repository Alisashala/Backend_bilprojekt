package bilprojekt.bilabonnement_backend.config;

import bilprojekt.bilabonnement_backend.entity.Customer;
import bilprojekt.bilabonnement_backend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Configuration
public class DeveloperData implements ApplicationRunner {

    private CustomerRepository repository;

    private static List<Customer> CUSTOMERS = Arrays.asList(
            new Customer("John Doe", "john@example.com", "Region A", 1112043092)
            // Add more customers as needed
    );

    public DeveloperData(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        // Ensure that IDs are not explicitly set
        CUSTOMERS.forEach(customer -> customer.setId(null));
        repository.saveAll(CUSTOMERS);
    }
}
