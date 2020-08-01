package mk.ukim.finki.ampleapi.service;

import mk.ukim.finki.ampleapi.domain.Person;
import mk.ukim.finki.ampleapi.repository.jpa.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonTestService {

    @Autowired
    private PersonRepository personRepository;

    public Optional<List<Person>> getAll(){
        return Optional.of(this.personRepository.findAll());
    }
}
