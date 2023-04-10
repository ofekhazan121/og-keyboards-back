package com.example.OGKeys.model;

import lombok.Data;

@Data
public class AuthenticationResponse {

    public final String jwt;
    public final String firstName;
    public final String lastName;
    public final String userName;
}
