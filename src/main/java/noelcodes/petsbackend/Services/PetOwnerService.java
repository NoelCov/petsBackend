package noelcodes.petsbackend.Services;

import jakarta.transaction.Transactional;
import noelcodes.petsbackend.Models.Pet;
import noelcodes.petsbackend.Models.PetOwner;
import noelcodes.petsbackend.Repositories.PetOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetOwnerService {

    private final PetOwnerRepository petOwnerRepository;

    @Autowired
    public PetOwnerService(PetOwnerRepository petOwnerRepository) {
        this.petOwnerRepository = petOwnerRepository;
    }

    public List<PetOwner> getPetOwners() {
        return petOwnerRepository.findAll();
    }

    public PetOwner getPetOwner(Long id) {
        return petOwnerRepository.findById(id).orElseThrow();
    }

    @Transactional
    public void createPetOwner(PetOwner petOwner) {
        petOwnerRepository.save(petOwner);
    }

    @Transactional
    public String deleteOwner(Long id) {
        if (petOwnerRepository.existsById(id)) {
            petOwnerRepository.deleteById(id);
            return String.format("Deleted owner with id: {%d}", id);
        } else {
            return String.format("Owner with id: {%d} does not exist.", id);
        }
    }

    @Transactional
    public String updateOwner(Long id, PetOwner petOwner) {
        if (petOwnerRepository.existsById(id)){
            petOwnerRepository.findById(id).ifPresent(currPetOwner -> {
                currPetOwner.setFirstName(petOwner.getFirstName());
                currPetOwner.setLastName(petOwner.getLastName());
                currPetOwner.setDob(petOwner.getDob());
                currPetOwner.setAddress(petOwner.getAddress());
                currPetOwner.setEmail(petOwner.getEmail());
                currPetOwner.setPassword(petOwner.getPassword());
                petOwnerRepository.save(currPetOwner);
            });
            return String.format("Owner with id: {%d} has been updated", id);
        } else {
            return String.format("Owner with id: {%d} does not exist.", id);
        }
    }

    public List<Pet> getOwnerPets(Long id) {
        PetOwner petOwner = getPetOwner(id);
        return petOwner.getPets();
    }

    public Optional<PetOwner> findOwnerByEmail(String email) {
        return petOwnerRepository.findByEmail(email);
    }
}
