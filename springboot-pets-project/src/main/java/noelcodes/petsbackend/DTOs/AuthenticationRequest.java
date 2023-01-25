package noelcodes.petsbackend.DTOs;

public record AuthenticationRequest(
        String email,
        String password
) {
}
