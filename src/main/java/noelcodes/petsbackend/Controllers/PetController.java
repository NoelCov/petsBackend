package noelcodes.petsbackend.Controllers;

import noelcodes.petsbackend.Models.Pet;
import noelcodes.petsbackend.Services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/pets")
public class PetController {

    private final PetService petService;

    // This annotation (Autowired) is so that Spring can inject an instance of petService.
    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    // Get all pets
    @GetMapping()
    public List<Pet> getPets() {
            return petService.getPets();
        };

    @GetMapping("/{id}")
    public Optional<Pet> getPet(@PathVariable("id") long id) {
        return petService.getPet(id);
    }

    @PostMapping()
    public Pet createPet(@RequestBody Pet pet){
        return petService.createPet(pet);
    }

    @DeleteMapping("/{id}")
    public String deletePet(@PathVariable("id") Long id){
        return petService.deletePet(id);
    }
}
