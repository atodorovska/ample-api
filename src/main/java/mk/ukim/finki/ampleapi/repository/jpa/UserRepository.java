package mk.ukim.finki.ampleapi.repository.jpa;

import mk.ukim.finki.ampleapi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);
    boolean existsByUniqueAuthenticator(String uniqueAuthenticator);
    boolean existsByUsername(String username);
    Optional<User> findByUsername(String username);

}
