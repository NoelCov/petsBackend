package noelcodes.petsbackend.DTOs;

import java.time.LocalDate;
import java.util.ArrayList;

public record PetRequestDTO(
        String name,
        String breed,
        LocalDate dob,
        String furColor,
        ArrayList<String> medicalConditions
) {
}
