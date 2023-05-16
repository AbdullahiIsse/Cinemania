package com.sep.cinemania.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity(name = "user_account")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @Column(name = "user_id")
    @NotBlank(message = "id is mandatory")
    private String id;
    @Column(name = "displayname")
    @NotBlank(message = "displayname is mandatory")
    private String displayName;
    @NotBlank(message = "email is mandatory")
    @Email
    private String email;
}
