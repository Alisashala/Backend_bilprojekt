package bilprojekt.bilabonnement_backend.entity;
import jakarta.persistence.*;

@Entity
public class DamageReport {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 10)
    private Long id;

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

    @Column(name = "damage_cost", nullable = false)
    private double damageCost;


    public DamageReport() {
        // Default constructor
    }



    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getDamageCost() {
        return damageCost;
    }

    public void setDamageCost(double damageCost) {
        this.damageCost = damageCost;
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

    public DamageReport(double damageCost, String brand, String model, String damageType, String damageDescription, String damageLevel) {
        this.damageCost = damageCost;
        this.brand = brand;
        this.model = model;
        this.damageType = damageType;
        this.damageDescription = damageDescription;
        this.damageLevel = damageLevel;
    }
}