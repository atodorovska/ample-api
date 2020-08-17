package mk.ukim.finki.ampleapi.service.impl;

import mk.ukim.finki.ampleapi.domain.Person;
import mk.ukim.finki.ampleapi.domain.User;
import mk.ukim.finki.ampleapi.domain.dto.ActiveUserDto;
import mk.ukim.finki.ampleapi.domain.dto.EditProfileDto;
import mk.ukim.finki.ampleapi.repository.jpa.PersonRepository;
import mk.ukim.finki.ampleapi.repository.jpa.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserManagementServiceImpl implements mk.ukim.finki.ampleapi.service.UserManagementService {

    private final UserRepository userRepository;
    private final PersonRepository personRepository;

    public UserManagementServiceImpl(UserRepository userRepository, PersonRepository personRepository) {
        this.userRepository = userRepository;
        this.personRepository = personRepository;
    }

    @Override
    public Optional<ActiveUserDto> getAllUserInfo(String username) {
        User user = this.userRepository.findByUsername(username).get();
        Person person = this.personRepository.findById(user.getPerson()).get();
        return Optional.of(new ActiveUserDto(user.getUsername(), user.getEmail(), user.getRole(),
                person.getPoints(), person.getAddress() != null ? person.getAddress(): "",
                person.getPhoneNumber() != null ? person.getPhoneNumber(): ""));
    }

    @Override
    @Transactional
    public void editProfile(EditProfileDto editProfileDto) {
        User user = this.userRepository.findByUsername(editProfileDto.getUsername()).get();
        Person person = this.personRepository.findById(user.getPerson()).get();

        if(!editProfileDto.getAddress().equals(""))
            person.setAddress(editProfileDto.getAddress());

        if(!editProfileDto.getNumber().equals(""))
            person.setPhoneNumber(editProfileDto.getNumber());
    }

    @Override
    @Transactional
    public void addPointsForSurvey(String username) {
        Long personId = this.userRepository.findByUsername(username).get().getPerson();
        Person person = this.personRepository.findById(personId).get();

        if(!person.getSurveyFilled()){
            person.setPoints(person.getPoints() + 150);
            person.setSurveyFilled(true);
        }

    }

}
