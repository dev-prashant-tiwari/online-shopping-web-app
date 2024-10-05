package com.web_application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "name is a required field")
    private String name;
    @Email(message = "please provide a valid email")
    @NotBlank(message = "email is a required field")
    private String email;
    @NotBlank(message = "password is a required field")
    private String password;

    private String mobile;

    private String role;
}
