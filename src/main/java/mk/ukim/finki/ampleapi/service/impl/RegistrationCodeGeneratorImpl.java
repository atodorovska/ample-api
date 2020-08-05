package mk.ukim.finki.ampleapi.service.impl;

import mk.ukim.finki.ampleapi.service.RegistrationCodeGenerator;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RegistrationCodeGeneratorImpl implements RegistrationCodeGenerator {

    @Override
    public String generateActivationCode(){
        return UUID.randomUUID().toString();
    }
}
