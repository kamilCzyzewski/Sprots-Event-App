package com.event.app.sports.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder
public class UserModel {

    private Long id;
    private String username;
    private String firstName;
    private String surname;
    private String mail;
}
