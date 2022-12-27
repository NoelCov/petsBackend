package noelcodes.petsbackend.Services;

import noelcodes.petsbackend.Models.Pet;
import noelcodes.petsbackend.Models.PetOwner;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class PetOwnerService {

    public List<PetOwner> getPetsOwners() {
        return List.of(new PetOwner("Noel", "Covarrubias", LocalDate.of(2022, Month.DECEMBER, 10), "123 Main Street"));
    }
}
