package com.example.OGKeys.model;


import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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

    @NotNull(message = "User Name Must Be Filled")
    @Pattern(regexp = "^([a-zA-Z0-9]{4,12})$", message = "User Name must Be Between 4-12 Characters With No Special Symbols ")
    String userName;

    @NotNull(message = "Email Must Be Filled")
    @Pattern(regexp = "^(.+)@(.+).com$", message = "Email must end with .com at the end")
    String email;

    @NotNull(message = "Password must be filled")
    String password;

    Role role;

    @NotNull
    @Pattern(regexp = "^((?=.*[A-Za-z])).{1,20}$", message = "First Name Must Be Filled And Contain Only Letters")
    String firstName;

    @NotNull
    @Pattern(regexp = "^((?=.*[A-Za-z])).{1,20}$", message = "Last Name Must Be Filled And Contain Only Letters")
    String lastName;

    @Pattern(regexp = "^[0-9]{10}$",message = "Phone Must Be 10 digits")
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

