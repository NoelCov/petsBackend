package noelcodes.petsbackend.Services;

import noelcodes.petsbackend.Models.Pet;
import noelcodes.petsbackend.Models.PetOwner;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class PetService {
    public List<Pet> getPets() {
        return List.of(
                new Pet("Demon", "Pitbull", LocalDate.of(2018, Month.DECEMBER, 5), "Gray", new PetOwner())
        );
    };
}
