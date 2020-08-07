package mk.ukim.finki.ampleapi.service;

import mk.ukim.finki.ampleapi.domain.exceptions.CreateUserException;

public interface RegistrationService {

    void createUnconfirmedUser(String username,
                               String password,
                               String email) throws CreateUserException;

    void activateUser(String username, String activationCode) throws CreateUserException;

    void removeOld();
}
