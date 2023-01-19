package noelcodes.petsbackend.Auth;

public class AuthenticationRequest {
    private final String email;
    private final String password;

    public AuthenticationRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
