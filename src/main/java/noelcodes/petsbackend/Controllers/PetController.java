package noelcodes.petsbackend.Controllers;

import noelcodes.petsbackend.Models.Pet;
import noelcodes.petsbackend.Services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/pets")
public class PetController {

    private final PetService petService;

    // This annotation (Autowired) is so that Spring can inject an instance of petService automatically.
    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    // Get all pets
    @GetMapping()
    public List<Pet> getPets() {
            return petService.getPets();
        };

    // Get one pet using the ID
    @GetMapping("/{id}")
    public Optional<Pet> getPet(@PathVariable("id") long id) {
        return petService.getPet(id);
    }

    // Create a pet and add to an existing owner
    @PostMapping("/{ownerId}")
    public Pet createPet(@RequestBody Pet pet, @PathVariable Long ownerId) {
        return petService.createPet(pet, ownerId);
    }
    
    // Delete a pet
    @DeleteMapping("/{id}")
    public String deletePet(@PathVariable("id") Long id){
        return petService.deletePet(id);
    }

    // Update a pet
    @PutMapping("/{id}")
    public String updatePet(@PathVariable("id") Long id, @RequestBody Pet pet) {
        return petService.updatePet(id, pet);
    }
}
