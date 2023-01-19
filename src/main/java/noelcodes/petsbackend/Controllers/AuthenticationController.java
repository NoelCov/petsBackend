package noelcodes.petsbackend.Controllers;

import noelcodes.petsbackend.Auth.AuthenticationRequest;
import noelcodes.petsbackend.Auth.AuthenticationResponse;
import noelcodes.petsbackend.Auth.RegisterRequest;
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
    public ResponseEntity<AuthenticationResponse> registerOwner(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authenticationService.registerOwner(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticateOwner(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authenticationService.authenticateOwner(request));
    }
}
