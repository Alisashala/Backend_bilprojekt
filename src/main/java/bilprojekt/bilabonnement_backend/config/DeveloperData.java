package bilprojekt.bilabonnement_backend.config;

import bilprojekt.bilabonnement_backend.entity.Customer;
import bilprojekt.bilabonnement_backend.entity.DamageReport;
import bilprojekt.bilabonnement_backend.repository.CustomerRepository;
import bilprojekt.bilabonnement_backend.repository.DamageReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Configuration
public class DeveloperData implements ApplicationRunner {

    private DamageReportRepository damageReportRepository;
    private CustomerRepository repository;

    //Statisk liste over lejeaftaleoplysninger
    private static List<Customer> CUSTOMERS = Arrays.asList(
            new Customer(1112035090, "Claus Nielsen", "clausnielsen@gmail.dk", "Sjælland", 2999, "Fiat", "500 Dolcevita", "Diesel", 21.8)
    );

    //Statisk liste over skaderapporter
    private static List<DamageReport> reports = Arrays.asList(
            new DamageReport(749.99, "Toyota", "Camry", "Collision", "Front bumper damage", "Moderate")
    );

    //Constructor for DeveloperData klassen
    public DeveloperData(CustomerRepository repository, DamageReportRepository damageReportRepository) {
        this.repository = repository;
        this.damageReportRepository = damageReportRepository;
    }


    // Metoden, der kaldes ved opstart af applikationen
    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        //Nulstiller ID for at undgå konflikter ved genindlæsning af data
        CUSTOMERS.forEach(customer -> customer.setId(null));
        //Gemmer lejeaftaler i repository
        repository.saveAll(CUSTOMERS);

        //Nulstiller ID for at undgå konflikter ved genindlæsning af data
        reports.forEach(report -> report.setId(null));
        //Gemmer skade rapporter i repository
        damageReportRepository.saveAll(reports);
    }
}