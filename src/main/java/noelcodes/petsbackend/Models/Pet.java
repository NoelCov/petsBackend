package noelcodes.petsbackend.Models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String breed;
    @Column(nullable = false)
    private LocalDate dob;
    @Column(nullable = false)
    private String furColor;
    @ManyToOne
    private PetOwner petOwner;

    // This default constructor is only used by JPA. That is why it needs to be set to protected.
    protected Pet() {}

    public Pet(String name, String breed, LocalDate dob, String furColor) {
        this.name = name;
        this.breed = breed;
        this.dob = dob;
        this.furColor = furColor;
    }

    public Pet(String name, String breed, LocalDate dob, String furColor, PetOwner petOwner) {
        this.name = name;
        this.breed = breed;
        this.dob = dob;
        this.furColor = furColor;
        this.petOwner = petOwner;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getFurColor() {
        return furColor;
    }

    public PetOwner getOwner() {
        return petOwner;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", dob=" + dob +
                ", furColor='" + furColor + '\'' +
                '}';
    }
}
