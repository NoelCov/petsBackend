package noelcodes.petsbackend.Services;

import jakarta.transaction.Transactional;
import noelcodes.petsbackend.Models.Pet;
import noelcodes.petsbackend.Repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    private final PetRepository petRepository;

    @Autowired
    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public List<Pet> getPets() {
        return petRepository.findAll();
    };

    public Optional<Pet> getPet(Long id) { return petRepository.findById(id); };

    public Pet createPet(Pet pet) {
        return petRepository.save(pet);
    }

    public String deletePet(Long id) {
        if (validatePet(id)) {
            petRepository.deleteById(id);
            return String.format("Pet with id {%d} provided deleted", id);
        } else {
            return String.format("No pet found with the id provided. Id: {%d}", id);
        }
    }

    // TODO add functionality to update pet owner
    @Transactional
    public String updatePet(Long id, Pet pet) {
        if (validatePet(id)) {
            petRepository.findById(id).ifPresent(updatedPet -> {
                // Update the entity and then save it to the db.
                updatedPet.setName(pet.getName());
                updatedPet.setBreed(pet.getBreed());
                updatedPet.setFurColor(pet.getFurColor());
                updatedPet.setDob(pet.getDob());
                petRepository.save(updatedPet);
            });
            return String.format("Pet with id: {%d} was updated.", id);
        } else {
            return String.format("No pet found with the id provided. Id: {%d}", id);
        }
    }

    private boolean validatePet(Long id){
        Optional<Pet> pet = getPet(id);
        return pet.isPresent();
    }
}
