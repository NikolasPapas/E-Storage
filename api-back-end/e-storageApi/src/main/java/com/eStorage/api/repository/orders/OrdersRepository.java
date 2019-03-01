package com.eStorage.api.repository.orders;

import ch.qos.logback.core.net.server.Client;
import com.eStorage.api.entitys.orders.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, UUID> {
    List<Orders> findAll();

    Orders findByOrdersId(UUID id);
}
