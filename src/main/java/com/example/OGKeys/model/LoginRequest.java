package com.example.OGKeys.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LoginRequest {
    @NotNull
    String userName;

    @NotNull
    String password;
}
