package com.eStorage.api.service.user;

import com.eStorage.api.entitys.user.Users;
import com.eStorage.api.models.UserForLogIn;
import com.eStorage.api.repository.users.UserRepository;
import com.eStorage.api.service.baseService.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserServiceImpl extends BaseServiceImpl {

    @Autowired
    private UserRepository userRepository;

    public UserForLogIn getUserForLogIn(String email, String password){
        Users users = userRepository.findUsersByEmailIsAndAndPasswordIs(email,password);
        return new UserForLogIn(email,password, Collections.singletonList(new SimpleGrantedAuthority(users.getRole().toString())));
    }

}
