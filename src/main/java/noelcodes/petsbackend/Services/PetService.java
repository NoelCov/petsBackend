package noelcodes.petsbackend.Services;

import noelcodes.petsbackend.Models.Pet;
import noelcodes.petsbackend.Repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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

    // TODO modify this one after testing getPets().
//    public int addPet(String name, String breed, String dob, String furColor) {
//        LocalDate correctDob = dob.equals("") ? LocalDate.now() : LocalDate.parse(dob);
//
//        return petRepository.addPet(name, breed, correctDob, furColor);
//    }
}
