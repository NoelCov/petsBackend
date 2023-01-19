package noelcodes.petsbackend.Auth;

import java.time.LocalDate;

public class RegisterRequest {
    private final String email;
    private final String password;
    private final String firstName;
    private final String lastName;
    private final LocalDate dob;
    private final String address;

    public RegisterRequest(
            String firstName,
            String lastName,
            String email,
            String password,
            LocalDate dob,
            String address) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getAddress() {
        return address;
    }
}
