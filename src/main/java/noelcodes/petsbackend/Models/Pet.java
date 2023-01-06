package noelcodes.petsbackend.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "PETS_TABLE")
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id", nullable = false)
    @JsonBackReference
    private PetOwner owner;

    // This default constructor is only used by JPA. That is why it needs to be set to protected.
    protected Pet() {}

    public Pet(String name, String breed, LocalDate dob, String furColor) {
        this.name = name;
        this.breed = breed;
        this.dob = dob;
        this.furColor = furColor;
    }

    public Long getId() { return id; }

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
        return owner;
    }

    public void setName(String name) {
        if (name != null && !name.equals("")){
            this.name = name;
        }
    }

    public void setBreed(String breed) {
        if (breed != null && !breed.equals("")){
            this.breed = breed;
        }
    }

    public void setDob(LocalDate dob) {
        int year = LocalDateTime.now().getYear();
        int month = LocalDateTime.now().getMonthValue();
        int day = LocalDateTime.now().getDayOfMonth();
        LocalDate oldestDogRecord = LocalDate.of(year - 30, month, day);

        if (dob != null && dob.isAfter(oldestDogRecord)){
            this.dob = dob;
        }
    }

    public void setFurColor(String furColor) {
        if (furColor != null && !furColor.equals("")){
            this.furColor = furColor;
        }
    }

    public void setOwner(PetOwner owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", dob=" + dob +
                ", furColor='" + furColor + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}
