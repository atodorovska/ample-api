package mk.ukim.finki.ampleapi.controller;

import mk.ukim.finki.ampleapi.domain.User;
import mk.ukim.finki.ampleapi.domain.dto.RegisterUserDto;
import mk.ukim.finki.ampleapi.domain.exceptions.CreateUserException;
import mk.ukim.finki.ampleapi.service.RegistrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/api/user")
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterUserDto userDto) throws CreateUserException {
        this.registrationService.createUnconfirmedUser(
                userDto.username,
                userDto.password,
                userDto.email);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/activate")
    public ResponseEntity activate (@RequestParam String username,
                                    @RequestParam String activationCode) throws CreateUserException{
        this.registrationService.activateUser(username, activationCode);
        return ResponseEntity.ok().body("Successful activation");
    }

    @GetMapping("/principal")
    public Principal getPrincipal(Principal principal) {
        return principal;
    }


    //remove this from here
    @GetMapping
    public ResponseEntity<User> getUserInfo(Principal principal) {
        return this.registrationService.findByUsername(principal.getName())
                .map(u -> ResponseEntity.ok().body(u))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}