package mk.ukim.finki.ampleapi.service.impl;

import mk.ukim.finki.ampleapi.domain.User;
import mk.ukim.finki.ampleapi.repository.jpa.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserManagementServiceImpl implements mk.ukim.finki.ampleapi.service.UserManagementService {

    private final UserRepository userRepository;

    public UserManagementServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }
}
