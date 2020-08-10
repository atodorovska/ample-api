package mk.ukim.finki.ampleapi.service.impl;

import mk.ukim.finki.ampleapi.repository.jpa.UnconfirmedUserRepository;
import mk.ukim.finki.ampleapi.repository.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Primary
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository.findByUsername(username)
                .map(u -> new User(
                        u.getUsername(),
                        u.getPassword(),
                        Stream
                                .of(new SimpleGrantedAuthority(String.format("ROLE_%s", u.getRole().toString())))
                                .collect(Collectors.toList())
                )).orElseThrow(() -> new UsernameNotFoundException(
                        String.format("Username %s not found", username)
                ));
    }
}
