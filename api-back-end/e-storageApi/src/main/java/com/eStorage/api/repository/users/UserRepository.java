package com.eStorage.api.repository.users;

import ch.qos.logback.core.net.server.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.eStorage.api.entitys.user.Users;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<Users, UUID> {
    List<Users> findAll();

    Users findByUsersId(UUID id);


}
