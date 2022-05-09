package com.event.app.sports.model.dto;

import lombok.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder
public class RegistrationFormDTO {

    @NotBlank(message = "Pole musi być uzupełnione")
    private String username;

    @NotBlank(message = "Pole musi być uzupełnione")
    private String firstName;

    @NotBlank(message = "Hasło nie może być puste")
    private String surname;

    @NotBlank(message = "Pole musi być uzupełnione")
    @Pattern(regexp="(?=^.{8,}$)(?=.*\\d)(?=.*[!@#$%^&*]+)(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$")
    private String passwordFirstTry;

    @NotBlank(message = "Pole musi być uzupełnione")
    @Pattern(regexp="(?=^.{8,}$)(?=.*\\d)(?=.*[!@#$%^&*]+)(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$")
    private String passwordSecondTry;


}
