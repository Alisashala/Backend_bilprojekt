package bilprojekt.bilabonnement_backend.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class DamageReport {

    @OneToMany(mappedBy = "damageReport")
    private List<Registration> registrations;


    @Column(name = "id", nullable = false, length = 10)
    @Id
    private Long damageReport;

    @Column(name = "brand", nullable = false, length = 50)
    private String brand;

    @Column(name = "model", nullable = false, length = 50)
    private String model;

    @Column(name = "damage_type", nullable = false, length = 100)
    private String damageType;

    @Column(name = "damage_description", nullable = false, length = 200)
    private String damageDescription;

    @Column(name = "damage_level", nullable = false, length = 50)
    private String damageLevel;

    public DamageReport() {
        // Default constructor
    }

    public List<Registration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(List<Registration> registrations) {
        this.registrations = registrations;
    }

    public Long getId() {
        return damageReport;
    }

    public void setId(Long id) {
        this.damageReport = damageReport;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDamageType() {
        return damageType;
    }

    public void setDamageType(String damageType) {
        this.damageType = damageType;
    }

    public String getDamageDescription() {
        return damageDescription;
    }

    public void setDamageDescription(String damageDescription) {
        this.damageDescription = damageDescription;
    }

    public String getDamageLevel() {
        return damageLevel;
    }

    public void setDamageLevel(String damageLevel) {
        this.damageLevel = damageLevel;
    }

    public DamageReport(List<Registration> registrations, Long damageReport, String brand, String model, String damageType, String damageDescription, String damageLevel) {
        this.registrations = registrations;
        this.damageReport = damageReport;
        this.brand = brand;
        this.model = model;
        this.damageType = damageType;
        this.damageDescription = damageDescription;
        this.damageLevel = damageLevel;
    }
}