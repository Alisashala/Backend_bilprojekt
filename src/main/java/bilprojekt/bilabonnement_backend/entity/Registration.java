package bilprojekt.bilabonnement_backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cpr;

    private String email;

    public Registration() {
        // Default constructor
    }

    public Registration(Long id, String cpr, String email) {
        this.id = id;
        this.cpr = cpr;
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCpr(String cpr) {
        this.cpr = cpr;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getCpr() {
        return cpr;
    }

    public String getEmail() {
        return email;
    }
}