package com.eStorage.api.security;

import com.eStorage.api.models.UserForLogIn;
import com.eStorage.api.service.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class AccountLoginAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    UserServiceImpl userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        UserForLogIn loginResponse = authenticateUser(authentication);
        return new UsernamePasswordAuthenticationToken(loginResponse.getEmail(), loginResponse.getPassword(), loginResponse.getRole());
    }



    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    private UserForLogIn authenticateUser(Authentication authentication) {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();

        UserForLogIn person = userService.getUserForLogIn(username, password);

        if(person==null){
            throw new BadCredentialsException("User or password incorrect");
        }else {

            return person;
        }

    }
}
