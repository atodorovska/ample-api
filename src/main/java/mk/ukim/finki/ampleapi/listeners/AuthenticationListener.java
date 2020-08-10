package mk.ukim.finki.ampleapi.listeners;

import mk.ukim.finki.ampleapi.domain.Person;
import mk.ukim.finki.ampleapi.domain.User;
import mk.ukim.finki.ampleapi.repository.jpa.PersonRepository;
import mk.ukim.finki.ampleapi.repository.jpa.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AuthenticationListener { //implements AuthenticationSuccessHandler {

    private UserRepository userRepository;
    private PersonRepository personRepository;
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationListener.class);

    public AuthenticationListener(UserRepository userRepository, PersonRepository personRepository){
        this.userRepository = userRepository;
        this.personRepository = personRepository;
    }

    @EventListener
    public void onAuthenticationSuccess(AuthenticationSuccessEvent authenticationSuccessEvent) {
        logger.info("User authenticated event caught");
        try {
            OAuth2Authentication authentication = (OAuth2Authentication) authenticationSuccessEvent.getAuthentication();
            Map<String, String> details = (Map<String, String>) authentication.getUserAuthentication().getDetails();

            String username = details.get("name");
            String auth_id = details.get("id") != null ? details.get("id") : details.get("sub");

            if(!this.userRepository.existsByUsername(username) || !this.userRepository.existsByUniqueAuthenticator(auth_id)){
                logger.info("Creating new user - OAuth2");
                Person person = new Person(1000);
                this.personRepository.save(person);
                User user = new User(username, auth_id, person.getId());
                this.userRepository.save(user);
            }
        } catch (ClassCastException ex) {
            logger.info("Can not cast => local authentication");
        }
    }
}
