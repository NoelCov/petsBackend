package noelcodes.petsbackend.Services;

import noelcodes.petsbackend.Models.Pet;
import noelcodes.petsbackend.Repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
        Optional<Pet> pet = getPet(id);
        if (pet.isEmpty()){
            return String.format("No pet found with the id provided. Id: {%d}", id);
        } else {
            petRepository.deleteById(id);
            return String.format("Pet with id {%d} provided deleted", id);
        }
    }
}
