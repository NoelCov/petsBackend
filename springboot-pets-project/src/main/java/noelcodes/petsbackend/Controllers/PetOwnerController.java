package noelcodes.petsbackend.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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
    @Operation(summary = "Gets all owners")
    public List<PetOwnerResponseDTO> getOwners() {
        List<PetOwner> petOwners = petOwnerService.getPetOwners();
        return petOwners.stream().map(petOwner ->
                new PetOwnerResponseDTO(
                        petOwner.getId(),
                        petOwner.getFirstName(),
                        petOwner.getLastName(),
                        petOwner.getEmail(),
                        petOwner.getPassword(),
                        petOwner.getDob(),
                        petOwner.getAddress()
                )).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Gets an owner")
    public PetOwnerResponseDTO getOwner(@PathVariable Long id) {
        PetOwner petOwner = petOwnerService.getPetOwner(id);
        return petOwner == null ? null :
        new PetOwnerResponseDTO(
                petOwner.getId(),
                petOwner.getFirstName(),
                petOwner.getLastName(),
                petOwner.getEmail(),
                petOwner.getPassword(),
                petOwner.getDob(),
                petOwner.getAddress()
                );
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletes an owner", security = @SecurityRequirement(name = "bearerAuth"))
    public String deleteOwner(@PathVariable Long id){
        return petOwnerService.deleteOwner(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Updates an owner", security = @SecurityRequirement(name = "bearerAuth"))
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
    @Operation(summary = "Gets pets owner by owner")
    public List<PetResponseDTO> findPetsByOwner(@PathVariable Long id) {
        return petOwnerService.getOwnerPets(id)
            .stream()
            .map(pet -> new PetResponseDTO(
                    pet.getId(),
                    pet.getName(),
                    pet.getBreed(),
                    pet.getDob(),
                    pet.getFurColor(),
                    pet.getOwner().getId(),
                    pet.getMedicalConditions()
            )).toList();
    }
}
