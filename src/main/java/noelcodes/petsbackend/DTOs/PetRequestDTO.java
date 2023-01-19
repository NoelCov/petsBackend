package noelcodes.petsbackend.DTOs;

import java.time.LocalDate;

public record PetRequestDTO(
        String name,
        String breed,
        LocalDate dob,
        String furColor
) {
}
