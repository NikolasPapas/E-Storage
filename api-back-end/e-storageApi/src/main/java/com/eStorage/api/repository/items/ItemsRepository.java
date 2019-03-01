package com.eStorage.api.repository.items;

import com.eStorage.api.entitys.items.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ItemsRepository extends JpaRepository<Items, UUID> {

}
