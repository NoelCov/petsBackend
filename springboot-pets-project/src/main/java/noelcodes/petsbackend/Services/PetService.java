package noelcodes.petsbackend.Services;

import jakarta.transaction.Transactional;
import noelcodes.petsbackend.Models.Pet;
import noelcodes.petsbackend.Models.PetOwner;
import noelcodes.petsbackend.Repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    private final PetRepository petRepository;
    private final PetOwnerService petOwnerService;
    @Autowired
    public PetService(PetRepository petRepository, PetOwnerService petOwnerService) {
        this.petRepository = petRepository;
        this.petOwnerService = petOwnerService;
    }

    public List<Pet> getPets() {
        return petRepository.findAll();
    };

    public Pet getPet(Long id) {
        Optional<Pet> pet = petRepository.findById(id);
        return pet.isEmpty() ? null : pet.get();
    };

    @Transactional
    public Pet createPet(Pet pet, Long ownerId) {
        PetOwner petOwner = petOwnerService.getPetOwner(ownerId);
        if (petOwner == null){
            return null;
        }
        pet.setOwner(petOwner);
        return petRepository.save(pet);
    }

    @Transactional
    public String deletePet(Long id) {
        try {
            petRepository.deleteById(id);
            return String.format("Pet with®id {%d} provided deleted", id);
        } catch (Exception e) {
            return String.format("No pet found with the id provided. Id: {%d}", id);
        }
    }

    @Transactional
    public String updatePet(Long id, Pet pet) {
        if (validatePet(id)) {
            petRepository.findById(id).ifPresent(currPet -> {
                // Update the entity and then save it to the db.
                currPet.setName(pet.getName());
                currPet.setBreed(pet.getBreed());
                currPet.setFurColor(pet.getFurColor());
                currPet.setDob(pet.getDob());
                petRepository.save(currPet);
            });
            return String.format("Pet with id: {%d} was updated.", id);
        } else {
            return String.format("No pet found with the id provided. Id: {%d}", id);
        }
    }

    private boolean validatePet(Long id){
        Optional<Pet> pet = petRepository.findById(id);
        return pet.isPresent();
    }
}
