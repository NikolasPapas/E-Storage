package com.eStorage.api.service.user;

import com.eStorage.api.repository.users.UserRepository;
import com.eStorage.api.service.baseService.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl {

    @Autowired
    private UserRepository userRepository;


}
