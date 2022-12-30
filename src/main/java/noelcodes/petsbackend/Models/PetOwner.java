package noelcodes.petsbackend.Models;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.util.List;

@Entity
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
    @OneToMany(mappedBy = "petOwner", fetch = FetchType.EAGER)
    private List<Pet> pets;

    // We don't use this constructor, it's only for Spring Data JPA.
    protected PetOwner() {}

    public PetOwner(String firstName, String lastName, LocalDate dob, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.address = address;
    }

    public PetOwner(String firstName, String lastName, LocalDate dob, String address, List<Pet> pets) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.address = address;
        this.pets = pets;
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
