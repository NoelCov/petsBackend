package noelcodes.petsbackend.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import noelcodes.petsbackend.DTOs.PetRequestDTO;
import noelcodes.petsbackend.DTOs.PetResponseDTO;
import noelcodes.petsbackend.Models.Pet;
import noelcodes.petsbackend.Services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/pets")
public class PetController {
    private final PetService petService;

    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping()
    @Operation(summary = "Gets all pets")
    public List<PetResponseDTO> getPets() {
        List<Pet> pets = petService.getPets();
        return pets.stream().map(
                pet -> new PetResponseDTO(
                        pet.getId(),
                        pet.getName(),
                        pet.getBreed(),
                        pet.getDob(),
                        pet.getFurColor(),
                        pet.getOwner().getId()
                )).collect(Collectors.toList());
    };

    @GetMapping("/{id}")
    @Operation(summary = "Gets a pet")
    public PetResponseDTO getPet(@PathVariable("id") long id) {
        Pet pet = petService.getPet(id);
        return new PetResponseDTO(
                pet.getId(),
                pet.getName(),
                pet.getBreed(),
                pet.getDob(),
                pet.getFurColor(),
                pet.getOwner().getId());
    }

    @Operation(summary = "Creates a new pet attached to the owner's id provided", security = @SecurityRequirement(name = "bearerAuth"))
    @PostMapping("/{ownerId}")
    public Pet createPet(@RequestBody PetRequestDTO petRequest, @PathVariable Long ownerId) {
        Pet pet = new Pet(petRequest.name(), petRequest.breed(), petRequest.dob(), petRequest.furColor());
        return petService.createPet(pet, ownerId);
    }

    @Operation(summary = "Deletes a pet", security = @SecurityRequirement(name = "bearerAuth"))
    @DeleteMapping("/{id}")
    public String deletePet(@PathVariable("id") Long id){
        return petService.deletePet(id);
    }

    @Operation(summary = "Updates a pet", security = @SecurityRequirement(name = "bearerAuth"))
    @PutMapping("/{id}")
    public String updatePet(@PathVariable("id") Long id, @RequestBody PetRequestDTO petRequest) {
        Pet pet = new Pet(petRequest.name(), petRequest.breed(), petRequest.dob(), petRequest.furColor());
        return petService.updatePet(id, pet);
    }
}
