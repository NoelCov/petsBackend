package noelcodes.petsbackend.DTOs;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import noelcodes.petsbackend.Models.Pet;
import noelcodes.petsbackend.Models.PetOwner;

import java.time.LocalDate;
import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PetOwnerDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String address;
    private String email;
    private String password;
    private List<Pet> pets;

    public PetOwnerDTO(PetOwner petOwner){
        this.id = petOwner.getId();
        this.firstName = petOwner.getFirstName();
        this.lastName = petOwner.getLastName();
        this.dob = petOwner.getDob();
        this.address = petOwner.getAddress();
        this.email = petOwner.getEmail();
        this.password = petOwner.getPassword();
        this.pets = petOwner.getPets();
    }
}
