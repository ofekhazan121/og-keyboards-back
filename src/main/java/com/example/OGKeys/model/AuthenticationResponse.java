package com.example.OGKeys.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collections;

@Data
public class AuthenticationResponse {

    public final String jwt;
    public final String firstName;
    public final String lastName;
    public final String userName;
    public final Role role;
}
