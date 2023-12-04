package bilprojekt.bilabonnement_backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DamageReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String damageType;
    private String description;
    // You can add more fields as needed

    // Constructors, getters, and setters

    public DamageReport() {
        // Default constructor
    }

    public DamageReport(String damageType, String description) {
        this.damageType = damageType;
        this.description = description;
    }

    // Getters and setters for other fields

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDamageType() {
        return damageType;
    }

    public void setDamageType(String damageType) {
        this.damageType = damageType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}