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
    private UserRepository authUserRepository;



    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AuthUser> authUser = authUserRepository.findByUserName(username);
        if (authUser.isPresent()){
            return new CustomUserDetails(authUser.get());
        }
        throw new UsernameNotFoundException("User Not Found");
    }
}
