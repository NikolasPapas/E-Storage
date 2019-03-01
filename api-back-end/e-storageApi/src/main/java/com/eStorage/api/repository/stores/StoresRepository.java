package com.eStorage.api.repository.stores;

import com.eStorage.api.entitys.stores.Stores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StoresRepository extends JpaRepository<Stores, UUID> {

}
