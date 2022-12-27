package noelcodes.petsbackend.Models;

import java.time.LocalDate;

public class Pet {
    private String name;
    private String breed;
    private LocalDate dob;
    private String furColor;
    private PetOwner petOwner;

    public Pet(String name, String breed, LocalDate dob, String furColor, PetOwner petOwner) {
        this.name = name;
        this.breed = breed;
        this.dob = dob;
        this.furColor = furColor;
        this.petOwner = petOwner;
    }

    public Pet() {}

    public void setName(String name) {
        this.name = name;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setFurColor(String furColor) {
        this.furColor = furColor;
    }

    public void setOwner(PetOwner petOwner) {
        this.petOwner = petOwner;
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
}
