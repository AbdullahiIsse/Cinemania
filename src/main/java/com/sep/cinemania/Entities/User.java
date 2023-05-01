package com.sep.cinemania.Entities;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @SequenceGenerator(name = "user_generator", sequenceName = "user_account_seq", allocationSize = 1)
    @Column(name = "user_id")
    private long id;
    private String username;
}
