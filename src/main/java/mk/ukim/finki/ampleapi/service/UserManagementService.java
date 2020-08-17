package mk.ukim.finki.ampleapi.service;

import mk.ukim.finki.ampleapi.domain.dto.ActiveUserDto;
import mk.ukim.finki.ampleapi.domain.dto.EditProfileDto;

import java.util.Optional;

public interface UserManagementService {

    Optional<ActiveUserDto> getAllUserInfo(String username);

    void editProfile(EditProfileDto editProfileDto);
}
