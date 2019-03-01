package com.eStorage.api.repository.items;

import ch.qos.logback.core.net.server.Client;
import com.eStorage.api.entitys.items.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ItemsRepository extends JpaRepository<Items, UUID> {
    List<Items> findAll();

    Items findByItemsId(UUID id);
}
