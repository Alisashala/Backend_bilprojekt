package bilprojekt.bilabonnement_backend.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Customer {


    @OneToMany(mappedBy = "customer")
    private List<Registration> registrations;


    @Column(name = "cpr", nullable = false, length = 10)
    @Id
    private Long cpr;

    @Column(name = "full_name", nullable = false, length = 50)
    private String fullName;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "region", nullable = false, length = 50)
    private String region;


    public List<Registration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(List<Registration> registrations) {
        this.registrations = registrations;
    }

    public Long getCpr() {
        return cpr;
    }

    public void setCpr(Long cpr) {
        this.cpr = cpr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Customer() {
    }

    public Customer(List<Registration> registrations, Long cpr, String fullName, String email, String region) {
        this.registrations = registrations;
        this.cpr = cpr;
        this.fullName = fullName;
        this.email = email;
        this.region = region;
    }
}
