package mk.ukim.finki.ampleapi.controller;

import mk.ukim.finki.ampleapi.domain.Person;
import mk.ukim.finki.ampleapi.domain.User;
import mk.ukim.finki.ampleapi.domain.dto.ActiveUserDto;
import mk.ukim.finki.ampleapi.domain.dto.EditProfileDto;
import mk.ukim.finki.ampleapi.service.UserManagementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/user")
public class UserManagementController {

    private final UserManagementService userManagementService;

    public UserManagementController(UserManagementService userManagementService) {
        this.userManagementService = userManagementService;
    }

    @GetMapping("/active")
    public ResponseEntity<ActiveUserDto> getAllUserInfo(Principal principal) {
        return this.userManagementService.getAllUserInfo(principal.getName())
                .map(u -> ResponseEntity.ok().body(u))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/edit")
    public void editProfile(@RequestBody EditProfileDto editProfileDto){
        this.userManagementService.editProfile(editProfileDto);
    }
}
