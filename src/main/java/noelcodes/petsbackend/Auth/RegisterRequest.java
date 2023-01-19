package noelcodes.petsbackend.Auth;

import java.time.LocalDate;

public record RegisterRequest(
        String firstName,
        String lastName,
        String email,
        String password,
        LocalDate dob,
        String address
) {
}
