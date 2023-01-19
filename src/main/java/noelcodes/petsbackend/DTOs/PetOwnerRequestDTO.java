package noelcodes.petsbackend.DTOs;

import java.time.LocalDate;

public record PetOwnerRequestDTO(
        String firstName,
        String lastName,
        LocalDate dob,
        String address,
        String email,
        String password) {
}
