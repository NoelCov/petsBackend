package noelcodes.petsbackend.DTOs;

import noelcodes.petsbackend.Models.Pet;

import java.time.LocalDate;

public class PetDTO {
    private long id = 0L;
    private final String name;
    private final String breed;
    private final LocalDate dob;
    private final String furColor;

    private long ownerId = 0L;

    public PetDTO(Pet pet) {
        this.id = pet.getId();
        this.name = pet.getName();
        this.breed = pet.getBreed();
        this.dob = pet.getDob();
        this.furColor = pet.getFurColor();
        this.ownerId = pet.getOwner().getId();
    }

    public PetDTO(String name, String breed, LocalDate dob, String furColor) {
        this.name = name;
        this.breed = breed;
        this.dob = dob;
        this.furColor = furColor;
    }

    public long getId() {
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

    public long getOwnerId() {
        return ownerId;
    }
}
