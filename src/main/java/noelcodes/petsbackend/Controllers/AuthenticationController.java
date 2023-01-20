package noelcodes.petsbackend.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import noelcodes.petsbackend.DTOs.AuthenticationRequest;
import noelcodes.petsbackend.DTOs.AuthenticationResponse;
import noelcodes.petsbackend.DTOs.PetOwnerRequestDTO;
import noelcodes.petsbackend.Services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }


    @PostMapping("/register")
    @Operation(summary = "Registers a new user")
    public ResponseEntity<AuthenticationResponse> registerOwner(@RequestBody PetOwnerRequestDTO request) {
        return ResponseEntity.ok(authenticationService.registerOwner(request));
    }

    @PostMapping("/authenticate")
    @Operation(summary = "Authenticates an existent user")
    public ResponseEntity<AuthenticationResponse> authenticateOwner(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authenticationService.authenticateOwner(request));
    }
}
