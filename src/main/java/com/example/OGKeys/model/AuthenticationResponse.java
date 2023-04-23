package com.example.OGKeys.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import java.util.Collections;

@Data
@AllArgsConstructor
public class AuthenticationResponse {

    public final String jwt;
    public final String firstName;
    public final String lastName;
    public final String userName;
    public final Role role;
    public String id;

    public AuthenticationResponse(String jwt, String firstName, String lastName, String userName, Role role) {
        this.jwt = jwt;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.role = role;
    }
}
