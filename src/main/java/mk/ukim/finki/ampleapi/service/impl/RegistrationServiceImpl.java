package mk.ukim.finki.ampleapi.service.impl;

import mk.ukim.finki.ampleapi.domain.Person;
import mk.ukim.finki.ampleapi.domain.UnconfirmedUser;
import mk.ukim.finki.ampleapi.domain.User;
import mk.ukim.finki.ampleapi.domain.exceptions.CreateUserException;
import mk.ukim.finki.ampleapi.repository.jpa.PersonRepository;
import mk.ukim.finki.ampleapi.repository.jpa.UnconfirmedUserRepository;
import mk.ukim.finki.ampleapi.repository.jpa.UserRepository;
import mk.ukim.finki.ampleapi.repository.mail.EmailSenderRepository;
import mk.ukim.finki.ampleapi.service.RegistrationCodeGenerator;
import mk.ukim.finki.ampleapi.service.RegistrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final UnconfirmedUserRepository unconfirmedUserRepository;
    private final UserRepository userRepository;
    private final PersonRepository personRepository;
    private final EmailSenderRepository emailSenderRepository;
    private final PasswordEncoder passwordEncoder;
    private final RegistrationCodeGenerator registrationCodeGenerator;

    private static final Logger logger = LoggerFactory.getLogger(RegistrationServiceImpl.class);
    private static final long MILLISECONDS_IN_DAY = 86400000;


    public RegistrationServiceImpl(UnconfirmedUserRepository unconfirmedUserRepository,
                                   UserRepository userRepository,
                                   PersonRepository personRepository, EmailSenderRepository emailSenderRepository,
                                   PasswordEncoder passwordEncoder,
                                   RegistrationCodeGenerator registrationCodeGenerator) {
        this.unconfirmedUserRepository = unconfirmedUserRepository;
        this.userRepository = userRepository;
        this.personRepository = personRepository;
        this.emailSenderRepository = emailSenderRepository;
        this.passwordEncoder = passwordEncoder;
        this.registrationCodeGenerator = registrationCodeGenerator;
    }

    @Override
    public void createUnconfirmedUser(String username,
                                      String password,
                                      String email) throws CreateUserException {
        logger.info("Creating unconfirmed user with username: [{}], email: [{}]", username, email);

        if(this.userRepository.existsByUsername(username) || this.unconfirmedUserRepository.existsByUsername(username)){
            throw new CreateUserException(String.format("Username: %s is already taken.", username));
        } else if(this.userRepository.existsByEmail(email)) {
            throw new CreateUserException(String.format("Email: %s is already taken.", email));
        }

        UnconfirmedUser unconfirmedUser = this.unconfirmedUserRepository.save(
                new UnconfirmedUser(
                        username,
                        passwordEncoder.encode(password),
                        email,
                        registrationCodeGenerator.generateActivationCode()));

        this.emailSenderRepository.sendAccountActivationEmail(
                unconfirmedUser.getEmail(),
                unconfirmedUser.getUsername(),
                unconfirmedUser.getActivationCode());
    }

    @Override
    public void activateUser(String username, String activationCode) throws CreateUserException {
        UnconfirmedUser unconfirmedUser = this.unconfirmedUserRepository
                                              .findByUsernameAndActivationCode(username, activationCode)
                                              .orElseThrow(() -> new CreateUserException(String.format("Incorrect username: %s or activation code: %s.", username, activationCode)));

        Person person = new Person(1000);
        this.personRepository.save(person);
        this.userRepository.save(new User(unconfirmedUser.getUsername(),
                unconfirmedUser.getPassword(),
                unconfirmedUser.getEmail(), person.getId()));
    }

    @Override
    public void removeOld() {
        Timestamp yesterday = new Timestamp(System.currentTimeMillis() - MILLISECONDS_IN_DAY);
        this.unconfirmedUserRepository.deleteAllByTimestampLessThan(yesterday);
    }

}
