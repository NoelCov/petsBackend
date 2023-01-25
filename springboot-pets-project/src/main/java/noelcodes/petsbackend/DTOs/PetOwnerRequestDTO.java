package noelcodes.petsbackend.DTOs;

import java.time.LocalDate;

public record PetOwnerRequestDTO(
        String firstName,
        String lastName,
        String email,
        String password,
        LocalDate dob,
        String address) {
}
