package com.eStorage.api.models;

import com.eStorage.api.entitys.user.EnumUserRole;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

public class UserForLogIn {

    private String email;
    private String password;
    private  List<SimpleGrantedAuthority> role;


    public UserForLogIn(String email, String password, List<SimpleGrantedAuthority> singletonList) {
        this.email=email;
        this.password=password;
        this.role=singletonList;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<SimpleGrantedAuthority> getRole() {
        return role;
    }

    public void setRole(List<SimpleGrantedAuthority> role) {
        this.role = role;
    }
}
