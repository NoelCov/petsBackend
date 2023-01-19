package noelcodes.petsbackend.Controllers;

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

    @PostMapping("/{ownerId}")
    public Pet createPet(@RequestBody PetRequestDTO petRequest, @PathVariable Long ownerId) {
        Pet pet = new Pet(petRequest.name(), petRequest.breed(), petRequest.dob(), petRequest.furColor());
        return petService.createPet(pet, ownerId);
    }

    @DeleteMapping("/{id}")
    public String deletePet(@PathVariable("id") Long id){
        return petService.deletePet(id);
    }

    @PutMapping("/{id}")
    public String updatePet(@PathVariable("id") Long id, @RequestBody PetRequestDTO petRequest) {
        Pet pet = new Pet(petRequest.name(), petRequest.breed(), petRequest.dob(), petRequest.furColor());
        return petService.updatePet(id, pet);
    }
}
