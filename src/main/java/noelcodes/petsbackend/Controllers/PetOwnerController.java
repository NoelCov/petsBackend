package noelcodes.petsbackend.Controllers;

import noelcodes.petsbackend.DTOs.PetOwnerRequestDTO;
import noelcodes.petsbackend.DTOs.PetOwnerResponseDTO;
import noelcodes.petsbackend.DTOs.PetResponseDTO;
import noelcodes.petsbackend.Models.PetOwner;
import noelcodes.petsbackend.Models.Role;
import noelcodes.petsbackend.Services.PetOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public List<PetOwnerResponseDTO> getOwners() {
        List<PetOwner> petOwners = petOwnerService.getPetOwners();
        return petOwners.stream().map(petOwner ->
                new PetOwnerResponseDTO(
                        petOwner.getId(),
                        petOwner.getFirstName(),
                        petOwner.getLastName(),
                        petOwner.getDob(),
                        petOwner.getAddress(),
                        petOwner.getEmail(),
                        petOwner.getPassword()
                )).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PetOwnerResponseDTO getOwner(@PathVariable Long id) {
        PetOwner petOwner = petOwnerService.getPetOwner(id);
        return new PetOwnerResponseDTO(
                petOwner.getId(),
                petOwner.getFirstName(),
                petOwner.getLastName(),
                petOwner.getDob(),
                petOwner.getAddress(),
                petOwner.getEmail(),
                petOwner.getPassword()
                );
    }

    @DeleteMapping("/{id}")
    public String deleteOwner(@PathVariable Long id){
        return petOwnerService.deleteOwner(id);
    }

    @PutMapping("/{id}")
    public String updateOwner(@PathVariable Long id, @RequestBody PetOwnerRequestDTO requestDTO){
        PetOwner petOwner = new PetOwner(
                requestDTO.firstName(),
                requestDTO.lastName(),
                requestDTO.dob(),
                requestDTO.address(),
                requestDTO.email(),
                requestDTO.password(),
                Role.USER
                );
        return petOwnerService.updateOwner(id, petOwner);
    }

    @GetMapping("/{id}/pets")
    public List<PetResponseDTO> findPetsByOwner(@PathVariable Long id) {
        return petOwnerService.getOwnerPets(id)
            .stream()
            .map(pet -> new PetResponseDTO(
                    pet.getId(),
                    pet.getName(),
                    pet.getBreed(),
                    pet.getDob(),
                    pet.getFurColor(),
                    pet.getOwner().getId()
            )).toList();
    }
}
