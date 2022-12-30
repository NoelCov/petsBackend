package noelcodes.petsbackend.Services;

import noelcodes.petsbackend.Models.PetOwner;
import noelcodes.petsbackend.Repositories.PetOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
