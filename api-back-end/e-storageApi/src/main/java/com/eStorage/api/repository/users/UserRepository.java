package com.eStorage.api.repository.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.eStorage.api.entitys.user.Users;

import java.util.UUID;


@Repository
public interface UserRepository extends JpaRepository<Users, UUID> {

    Users findUsersByEmailIsAndAndPasswordIs(String email,String password);
}
