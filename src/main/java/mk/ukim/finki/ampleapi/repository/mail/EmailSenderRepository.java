package mk.ukim.finki.ampleapi.repository.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

@Repository
public class EmailSenderRepository {

    @Autowired
    private JavaMailSender javaMailSender;

    private static final String ACTIVATION_URL = "Please click the following link to activate your account: http://localhost:8080/api/user/activate?username=%s&activationCode=%s";

    @Async
    public void sendAccountActivationEmail(String to, String username, String activationCode) {
        String messageBody = String.format(ACTIVATION_URL, username, activationCode);
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject("Ample account activation");
        simpleMailMessage.setText(messageBody);
        javaMailSender.send(simpleMailMessage);
    }
}
