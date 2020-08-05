package mk.ukim.finki.ampleapi.repository.jpa;

import mk.ukim.finki.ampleapi.domain.UnconfirmedUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Optional;

@Repository
public interface UnconfirmedUserRepository extends JpaRepository<UnconfirmedUser, Long> {

    Optional<UnconfirmedUser> findByUsername(String username);
    boolean existsByUsername(String username);
    Optional<UnconfirmedUser> findByUsernameAndActivationCode(String username, String activationCode);
    void deleteAllByTimestampLessThan(Timestamp timestamp);
}
