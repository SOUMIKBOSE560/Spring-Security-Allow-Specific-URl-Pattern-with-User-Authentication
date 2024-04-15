package com.example.springsecuritytutorial.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDetailsConfig implements UserDetailsService {

    @Autowired
    private PasswordEncoderConfig pwConfig;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("USERNAME : " + username);

        if(username.equals("Soumik")){
            return User.builder()
                    .username("Soumik")
                    .password(pwConfig.encoder().encode("Soumik@1998"))
                    .roles("USER")
                    .build();
        }
        else if (username.equals("Hydra")) {
            return User.builder()
                    .username("Hydra")
                    .password(pwConfig.encoder().encode("Hydra@123"))
                    .roles("ADMIN")
                    .build();
        }
        throw new UsernameNotFoundException("USERNAME NOT FOUND");
    }
}
