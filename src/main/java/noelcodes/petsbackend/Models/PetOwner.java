package noelcodes.petsbackend.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "OWNERS_TABLE")
public class PetOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private LocalDate dob;

    @Column(nullable = false)
    private String address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner", fetch = FetchType.LAZY)
    @JsonManagedReference
    private final List<Pet> pets = new ArrayList<>();

    // We don't use this constructor, it's only for Spring Data JPA.
    protected PetOwner() {}

    public PetOwner(String firstName, String lastName, LocalDate dob, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getAddress() {
        return address;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setFirstName(String firstName) {
        if (firstName != null && !firstName.equals("")){
            this.firstName = firstName;
        }
    }

    public void setLastName(String lastName) {
        if (lastName != null && !lastName.equals("")) {
            this.lastName = lastName;
        }
    }

    public void setDob(LocalDate dob) {
        if (dob != null){
            this.dob = dob;
        }
    }

    public void setAddress(String address) {
        if (address != null && !address.equals("")){
            this.address = address;
        }
    }

    public void setPets(List<Pet> pets) {
        if (pets != null && !pets.isEmpty()){
            pets.forEach(pet -> pet.setOwner(this));
            this.pets.addAll(pets);
        }
    }

    @Override
    public String toString() {
        return "PetOwner{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dob +
                ", address='" + address + '\'' +
                ", pets=" + pets +
                '}';
    }
}
