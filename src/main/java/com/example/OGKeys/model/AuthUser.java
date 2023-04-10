package com.example.OGKeys.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class AuthUser {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String userName;
    String password;
    String email;
    Role role;
    String firstName;
    String lastName;
    String phoneNumber;


}

