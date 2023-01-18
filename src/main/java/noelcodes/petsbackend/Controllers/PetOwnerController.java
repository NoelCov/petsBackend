package noelcodes.petsbackend.Controllers;

import noelcodes.petsbackend.DTOs.PetOwnerDTO;
import noelcodes.petsbackend.Models.Pet;
import noelcodes.petsbackend.Models.PetOwner;
import noelcodes.petsbackend.Services.PetOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/owners")
public class PetOwnerController {
    private final PetOwnerService petOwnerService;

    @Autowired
    public PetOwnerController(PetOwnerService petOwnerService) {
        this.petOwnerService = petOwnerService;
    }

    @GetMapping
    public List<PetOwnerDTO> getOwners() {
        List<PetOwner> petOwners = petOwnerService.getPetOwners();
        return petOwners.stream().map(PetOwnerDTO::new).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<PetOwner> getOwner(@PathVariable Long id) {
        return petOwnerService.getPetOwner(id);
    }

    @PostMapping
    public PetOwner createOwner(@RequestBody PetOwner petOwner){
        return petOwnerService.createPetOwner(petOwner);
    }

    @DeleteMapping("/{id}")
    public String deleteOwner(@PathVariable Long id){
        return petOwnerService.deleteOwner(id);
    }

    @PutMapping("/{id}")
    public String updateOwner(@PathVariable Long id, @RequestBody PetOwner petOwner){
        return petOwnerService.updateOwner(id, petOwner);
    }

    @GetMapping("/{id}/pets")
    public List<Pet> findPetsByOwner(@PathVariable Long id) {
        return petOwnerService.getOwnerPets(id);
    }
}
