package noelcodes.petsbackend.Services;

import noelcodes.petsbackend.Auth.AuthenticationRequest;
import noelcodes.petsbackend.Auth.AuthenticationResponse;
import noelcodes.petsbackend.Auth.RegisterRequest;
import noelcodes.petsbackend.Models.PetOwner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final PetOwnerService petOwnerService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthenticationService(
            PetOwnerService petOwnerService,
            JwtService jwtService,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder) {
        this.petOwnerService = petOwnerService;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
    }

    public AuthenticationResponse registerOwner(RegisterRequest request) {
        PetOwner owner = new PetOwner(
                request.getFirstName(),
                request.getLastName(),
                request.getDob(),
                request.getAddress(),
                request.getEmail(),
                passwordEncoder.encode(request.getPassword())
                );
        petOwnerService.createPetOwner(owner);
        String jwtToken = jwtService.generateToken(owner);
        return new AuthenticationResponse(jwtToken);
    }

    public AuthenticationResponse authenticateOwner(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        PetOwner petOwner = petOwnerService.findOwnerByEmail(request.getEmail())
                .orElseThrow();
        String jwtToken = jwtService.generateToken(petOwner);
        return new AuthenticationResponse(jwtToken);
    }
}
