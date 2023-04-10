package com.example.OGKeys.config;

import com.example.OGKeys.model.AuthUser;
import com.example.OGKeys.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repository;


    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AuthUser> user = repository.findByUserName(username);

        System.out.println(user);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not Found");
        }
        return new CustomUserDetails(user.get());
    }
}
