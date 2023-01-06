package noelcodes.petsbackend.Controllers;

import noelcodes.petsbackend.Models.PetOwner;
import noelcodes.petsbackend.Services.PetOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/owners")
public class PetOwnerController {
    private final PetOwnerService petOwnerService;

    @Autowired
    public PetOwnerController(PetOwnerService petOwnerService) {
        this.petOwnerService = petOwnerService;
    }

    @GetMapping()
    public List<PetOwner> getOwners() {
        return petOwnerService.getPetOwners();
    }

    @GetMapping("/{id}")
    public Optional<PetOwner> getOwner(@PathVariable Long id) {
        return petOwnerService.getPetOwner(id);
    }

    @PostMapping()
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
}
