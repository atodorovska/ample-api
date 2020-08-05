package mk.ukim.finki.ampleapi.domain.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


public class RegisterUserDto {

    @NotNull
    @Pattern(regexp = "^(?=.{3,30}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$")
    public String username;

    @NotNull
    @Length(min = 5, max = 50)
    public String password;

    @NotNull
    @Email
    public String email;
}
