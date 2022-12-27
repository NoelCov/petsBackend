package noelcodes.petsbackend.Controllers;

import noelcodes.petsbackend.Models.Pet;
import noelcodes.petsbackend.Services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/api/pet")
public class PetController {

    private final PetService petService;

    // This annotation (Autowired) is so that Spring can inject an instance of petService.
    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("/pets")
        public List<Pet> getPets() {
            return petService.getPets();
        };

    @PostMapping("/addPet")
    public int addPet(@RequestParam String name, @RequestParam String breed,
                      @RequestParam String dob, @RequestParam String furColor) {
        return petService.addPet(name, breed, dob, furColor);
    }
}
