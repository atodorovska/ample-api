package mk.ukim.finki.ampleapi.service;

import mk.ukim.finki.ampleapi.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserManagementService {
    Optional<User> findByUsername(String username);
}
