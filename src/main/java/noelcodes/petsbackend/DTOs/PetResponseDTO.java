package noelcodes.petsbackend.DTOs;

import java.time.LocalDate;

public record PetResponseDTO(long id, String name, String breed, LocalDate dob, String furColor, long ownerId) {
}
