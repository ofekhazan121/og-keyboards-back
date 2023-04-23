package com.example.OGKeys.service;

import com.example.OGKeys.model.AuthUser;
import com.example.OGKeys.model.Role;
import com.example.OGKeys.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public boolean userExist (String userName) {
        Optional<AuthUser> user = repository.findByUserName(userName);
        return user.isPresent();
    }

    public boolean addUser (AuthUser user) {
        try {
            Optional<AuthUser> checkUserName = repository.findByUserName(user.getUserName());
            Optional<AuthUser> checkEmail = repository.findByEmail(user.getEmail());

            if (checkUserName.isEmpty() && checkEmail.isEmpty()){
                user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
                user.setRole(Role.CLIENT);
                repository.save(user);
                return true;
            }
            return false;
        }catch (Exception e){
            return false;
        }
    }


}
