
package bilprojekt.bilabonnement_backend.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Customer customer;
    @ManyToOne
    private DamageReport damageReport;

    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime lastEdited;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer member) {
        this.customer = member;
    }

    public DamageReport getDamageReport() {
        return damageReport;
    }

    public void setCar(DamageReport damageReport) {
        this.damageReport = damageReport;
    }


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

    public Registration(Long id, Customer customer, DamageReport damageReport, LocalDateTime created, LocalDateTime lastEdited) {
        this.id = id;
        this.customer = customer;
        this.damageReport = damageReport;
        this.created = created;
        this.lastEdited = lastEdited;
    }
}

