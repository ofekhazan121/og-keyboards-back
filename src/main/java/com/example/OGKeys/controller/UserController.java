package com.example.OGKeys.controller;

import com.example.OGKeys.config.CustomUserDetails;
import com.example.OGKeys.config.CustomUserDetailsService;
import com.example.OGKeys.model.AuthUser;
import com.example.OGKeys.model.AuthenticationResponse;
import com.example.OGKeys.service.JwtService;
import com.example.OGKeys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;


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
    public ResponseEntity<String> signUp (@RequestBody AuthUser user) {

        if (service.addUser(user)){
            return ResponseEntity.ok().body("User Signed Up Successfully");
        }
        return ResponseEntity.badRequest().body("Something Went Wrong");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthUser user) throws Exception{
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    user.getUserName(),user.getPassword()));

        }catch (BadCredentialsException e){
            throw new Exception("incorrect username/password",e);
        }
        final CustomUserDetails userDetails = userDetailsService.loadUserByUsername(user.getUserName());
        final String jwt = jwtService.generateToken(userDetails);

        return ResponseEntity.ok().body(
                new AuthenticationResponse(
                        jwt,userDetails.getFirstName(),userDetails.getLastName(),userDetails.getUsername())
        );
    }


    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
