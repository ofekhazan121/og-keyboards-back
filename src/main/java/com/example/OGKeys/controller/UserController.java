package com.example.OGKeys.controller;

import com.example.OGKeys.config.CustomUserDetails;
import com.example.OGKeys.config.CustomUserDetailsService;
import com.example.OGKeys.model.AuthUser;
import com.example.OGKeys.model.AuthenticationResponse;
import com.example.OGKeys.model.LoginRequest;
import com.example.OGKeys.model.Role;
import com.example.OGKeys.service.JwtService;
import com.example.OGKeys.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserService service;

    @PostMapping("/signup")
    public ResponseEntity<?> signUp (@Valid @RequestBody AuthUser user, Errors errors) {
        if (errors.hasErrors()) {
            ArrayList<String> errorList = new ArrayList<>();
            errors.getAllErrors().forEach((error -> {
                errorList.add(error.getDefaultMessage());
            }));
            return ResponseEntity.badRequest().body(errorList);
        }
        if (service.addUser(user)){
            return ResponseEntity.ok().body("User Signed Up Successfully");
        }
        return ResponseEntity.badRequest().body("Username Or Email already in use");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest user, Errors errors) throws Exception{
        if (errors.hasErrors()) {
            ArrayList<String> errorList = new ArrayList<>();
            errors.getAllErrors().forEach((error -> {
                errorList.add(error.getDefaultMessage());
            }));
            return ResponseEntity.badRequest().body(errorList);
        }
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    user.getUserName(),user.getPassword()));

        }catch (BadCredentialsException e){
            throw new Exception("incorrect username/password",e);
        }
        final CustomUserDetails userDetails = userDetailsService.loadUserByUsername(user.getUserName());
        final String jwt = jwtService.generateToken(userDetails);

        if (userDetails.getRole() != Role.CLIENT){
            return ResponseEntity.ok().body(
                    new AuthenticationResponse(
                            jwt,
                            userDetails.getFirstName(),
                            userDetails.getLastName(),
                            userDetails.getUsername(),
                            userDetails.getRole(),
                            userDetails.getId())
            );
        }
        return ResponseEntity.ok().body(
                new AuthenticationResponse(
                        jwt,
                        userDetails.getFirstName(),
                        userDetails.getLastName(),
                        userDetails.getUsername(),
                        userDetails.getRole())
        );
    }

    @PostMapping("/checkJWT")
    public ResponseEntity<?> checkJWT(){
        return ResponseEntity.status(200).body("JWT is Valid");
    }

}
