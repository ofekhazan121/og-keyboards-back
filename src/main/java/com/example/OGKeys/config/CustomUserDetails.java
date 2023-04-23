package com.example.OGKeys.config;


import com.example.OGKeys.model.AuthUser;
import com.example.OGKeys.model.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Collections;


public class CustomUserDetails implements UserDetails {

    private AuthUser authUser;

    public CustomUserDetails(AuthUser authUser){
        super();
        this.authUser = authUser;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(authUser.getRole().name()));
    }

    public Role getRole(){
        return authUser.getRole();
    }

    @Override
    public String getPassword() {
        return authUser.getPassword();
    }

    @Override
    public String getUsername() {
        return authUser.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getFirstName() {
        return authUser.getFirstName();
    }

    public String getLastName() {
        return authUser.getLastName();
    }

    public String getId() {
        return authUser.getId();
    }
}
