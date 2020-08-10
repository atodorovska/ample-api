package mk.ukim.finki.ampleapi.controller;

import mk.ukim.finki.ampleapi.domain.dto.RegisterUserDto;
import mk.ukim.finki.ampleapi.domain.exceptions.CreateUserException;
import mk.ukim.finki.ampleapi.service.RegistrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/api/auth")
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
    public void activate (@RequestParam String username,
                                    @RequestParam String activationCode,
                                    HttpServletResponse response) throws CreateUserException, IOException {
        this.registrationService.activateUser(username, activationCode);
        response.sendRedirect("http://localhost:3000");
    }

}
