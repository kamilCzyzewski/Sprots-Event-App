package com.event.app.sports.model.dto;

import com.event.app.sports.repository.entity.UserEntity;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RegistrationFormDTO implements Serializable {

    @NotBlank(message = "Pole musi być uzupełnione")
    private String username;

    @NotBlank(message = "Pole musi być uzupełnione")
    private String firstName;

    @NotBlank(message = "Pole musi być uzupełnione")
    private String surname;

    @Pattern(regexp="(?=^.{8,}$)(?=.*\\d)(?=.*[!@#$%^&*]+)(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$", message = "Hasło musi posiadać co najmniej 8 znaków, w tym dużą literę, małą literę, cyfrę oraz znak specjalny")
    private String password;

    @Email(message = "Tu musi być wprowadzony email")
    @NotBlank(message = "Pole musi być uzupełnione")
    private String mail;

    @Override
    public String toString() {
        return "RegistrationFormDTO{" +
                "username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + "***" + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }

    public UserEntity toUserEntity(PasswordEncoder passwordEncoder){
        UserEntity user = new UserEntity();
        user.setUsername(this.username);
        user.setFirstName(this.firstName);
        user.setSurname(this.surname);
        user.setPassword(passwordEncoder.encode(this.password));
        user.setMail(this.mail);

        return user;
    }
}
