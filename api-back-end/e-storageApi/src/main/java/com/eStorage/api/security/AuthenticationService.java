package com.eStorage.api.security;

import com.eStorage.api.entitys.user.EnumUserRole;
import com.eStorage.api.models.UserForLogIn;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collections;


@Service
public class AuthenticationService {

     public UserForLogIn login(String email, String password){
         return new UserForLogIn(email, password, Collections.singletonList(new SimpleGrantedAuthority(EnumUserRole.USER.toString())));
     }


    public void logout(String email, String password){


    };


}
