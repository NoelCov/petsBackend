package noelcodes.petsbackend.Services;

import noelcodes.petsbackend.DTOs.AuthenticationRequest;
import noelcodes.petsbackend.DTOs.AuthenticationResponse;
import noelcodes.petsbackend.DTOs.PetOwnerRequestDTO;
import noelcodes.petsbackend.Models.PetOwner;
import noelcodes.petsbackend.Models.Role;
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

    public AuthenticationResponse registerOwner(PetOwnerRequestDTO request) {
        PetOwner owner = new PetOwner(
                request.firstName(),
                request.lastName(),
                request.dob(),
                request.address(),
                request.email(),
                passwordEncoder.encode(request.password()),
                Role.USER
                );
        petOwnerService.createPetOwner(owner);
        String jwtToken = jwtService.generateToken(owner);
        return new AuthenticationResponse(jwtToken);
    }

    public AuthenticationResponse authenticateOwner(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );
        PetOwner petOwner = petOwnerService.findOwnerByEmail(request.email())
                .orElseThrow();
        String jwtToken = jwtService.generateToken(petOwner);
        return new AuthenticationResponse(jwtToken);
    }
}
