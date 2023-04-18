package com.example.OGKeys.model;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import lombok.Data;
//
//
//@Entity
//@Data
//public class AuthUser {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    String id;
//    String userName;
//    String password;
//    String email;
//    Role role;
//    String firstName;
//    String lastName;
//    String phoneNumber;
//
//
//}


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class AuthUser {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    String userName;
    String email;
    String password;
    Role role;
    String firstName;
    String lastName;
    String phoneNumber;

    public AuthUser(String username,String password){
        this.userName = username;
        this.password = password;
    }

    public AuthUser(String username, String password, Role role) {
        this.userName = username;
        this.password = password;
        this.role = role;
    }
}

