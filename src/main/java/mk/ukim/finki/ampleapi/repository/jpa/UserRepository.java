package mk.ukim.finki.ampleapi.repository.jpa;

import mk.ukim.finki.ampleapi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
    boolean existsByUniqueAuthenticator(String auth);
    Optional<User> findByUniqueAuthenticator(String auth);
    Optional<User> findByUsername(String username);
}
