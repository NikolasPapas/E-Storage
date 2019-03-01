package com.eStorage.api.repository.client;

import com.eStorage.api.entitys.client.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface ClientRepository extends JpaRepository<Clients, UUID> {

}
