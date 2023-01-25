package noelcodes.petsbackend.DTOs;

import java.time.LocalDate;
import java.util.ArrayList;

public record PetResponseDTO(long id, String name, String breed, LocalDate dob, String furColor, long ownerId, ArrayList<String> medicalConditions) {
}
