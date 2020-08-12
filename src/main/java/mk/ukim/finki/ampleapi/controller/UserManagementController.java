package mk.ukim.finki.ampleapi.controller;

import mk.ukim.finki.ampleapi.domain.User;
import mk.ukim.finki.ampleapi.service.UserManagementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/user")
public class UserManagementController {

    private final UserManagementService userManagementService;

    public UserManagementController(UserManagementService userManagementService) {
        this.userManagementService = userManagementService;
    }

    @GetMapping("/active")
    public ResponseEntity<User> getUserInfo(Principal principal) {
        return this.userManagementService.findByUsername(principal.getName())
                .map(u -> ResponseEntity.ok().body(u))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
