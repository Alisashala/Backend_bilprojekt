package bilprojekt.bilabonnement_backend.entity;

import bilprojekt.bilabonnement_backend.entity.Customer;
import bilprojekt.bilabonnement_backend.entity.DamageReport;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

//Entity: Dette bruges til at angive, at klassen er en JPA-entity, hvilket betyder, at den repræsenterer en tabel i en database.
@Entity
public class Registration {


    //ID: Unik identifikation til hver skade rapport (primary key) genereret af databasen
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    //@ManyToOne: Dette angiver, at der er en many-to-one-relation mellem den Registration tabel og målentiteten (Customer og DamageReport).
    //@JoinColumn: Denne annotation bruges til at specificere, hvilken kolonne der skal bruges som join-kolonnen i databasen.
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "damage_report_id", nullable = false)
    private DamageReport damageReport;


    //@CreationTimeStamp: er en del af Hibernate og bruges til automatisk at indstille feltet created til tidspunktet for oprettelsen af en ny række i databasen.
    @CreationTimestamp
    private LocalDateTime created;

    //Ligesom @CreationTimestamp, men det opdaterer lastEdited-feltet hver gang entiteten opdateres i databasen.
    @UpdateTimestamp
    private LocalDateTime lastEdited;



    //Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    // Corrected method name
    public DamageReport getDamageReport() {
        return damageReport;
    }

    // Corrected method name
    public void setDamageReport(DamageReport damageReport) {
        this.damageReport = damageReport;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getLastEdited() {
        return lastEdited;
    }

    public void setLastEdited(LocalDateTime lastEdited) {
        this.lastEdited = lastEdited;
    }

    public Registration() {
    }

    // Constructor
    public Registration(Long id, Customer customer, DamageReport damageReport, LocalDateTime created, LocalDateTime lastEdited) {
        this.id = id;
        this.customer = customer;
        this.damageReport = damageReport;
        this.created = created;
        this.lastEdited = lastEdited;
    }
}
