package bilprojekt.bilabonnement_backend.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 10)
    private Long id;

    @Column(name = "cpr", nullable = false, length = 10)
    private int cpr;

    @Column(name = "full_name", nullable = false, length = 50)
    private String fullName;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "region", nullable = false, length = 50)
    private String region;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "Braendstof", nullable = false)
    private String braendstof;

    @Column(name = "Km/l", nullable = false)
    private double kml;


    // Constructors

    public Customer(int cpr, String fullName, String email, String region, int price, String brand, String model, String braendstof, double kml) {
        this.cpr = cpr;
        this.fullName = fullName;
        this.email = email;
        this.region = region;
        this.price = price;
        this.brand = brand;
        this.model = model;
        this.braendstof = braendstof;
        this.kml = kml;
    }

    public Customer() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCpr() {
        return cpr;
    }

    public void setCpr(int cpr) {
        this.cpr = cpr;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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

    public String getBraendstof() {
        return braendstof;
    }

    public void setBraendstof(String braendstof) {
        this.braendstof = braendstof;
    }

    public double getKml() {
        return kml;
    }

    public void setKml(double kml) {
        this.kml = kml;
    }
}