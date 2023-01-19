package noelcodes.petsbackend.Controllers;

import noelcodes.petsbackend.DTOs.PetDTO;
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

    // This annotation (Autowired) is so that Spring can inject an instance of petService automatically.
    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    // Get all pets
    @GetMapping()
    public List<PetDTO> getPets() {
        List<Pet> pets = petService.getPets();
        return pets.stream().map(PetDTO::new).collect(Collectors.toList());
    };

    // Get one pet using the ID
    @GetMapping("/{id}")
    public PetDTO getPet(@PathVariable("id") long id) {
        Pet pet = petService.getPet(id);
        return new PetDTO(pet);
    }

    // Create a pet and add to an existing owner
    @PostMapping("/{ownerId}")
    public Pet createPet(@RequestBody PetDTO petDTO, @PathVariable Long ownerId) {
        Pet pet = new Pet(petDTO.getName(), petDTO.getBreed(), petDTO.getDob(), petDTO.getFurColor());
        return petService.createPet(pet, ownerId);
    }

    // Delete a pet
    @DeleteMapping("/{id}")
    public String deletePet(@PathVariable("id") Long id){
        return petService.deletePet(id);
    }

    // Update a pet
    @PutMapping("/{id}")
    public String updatePet(@PathVariable("id") Long id, @RequestBody PetDTO petDTO) {
        Pet pet = new Pet(petDTO.getName(), petDTO.getBreed(), petDTO.getDob(), petDTO.getFurColor());
        return petService.updatePet(id, pet);
    }
}
