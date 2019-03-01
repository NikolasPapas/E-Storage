package com.eStorage.api.repository.stores;

import ch.qos.logback.core.net.server.Client;
import com.eStorage.api.entitys.stores.Stores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StoresRepository extends JpaRepository<Stores, UUID> {
    List<Stores> findAll();

    Stores findByStoresId(UUID id);
}
