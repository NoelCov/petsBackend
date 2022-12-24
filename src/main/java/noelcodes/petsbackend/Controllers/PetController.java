package noelcodes.petsbackend.Controllers;

import noelcodes.petsbackend.Models.Pet;
import noelcodes.petsbackend.Models.PetOwner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "/api/pet")
public class PetController {

        @GetMapping("/pets")
        public List<Pet> getPets() {
            return List.of(
                    new Pet("Demon", "Pitbull", LocalDate.of(2018, Month.DECEMBER, 5), "Gray", new PetOwner())
            );
        };
}
