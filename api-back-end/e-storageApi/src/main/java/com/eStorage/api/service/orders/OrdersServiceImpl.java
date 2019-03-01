package com.eStorage.api.service.orders;

import com.eStorage.api.repository.orders.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrdersServiceImpl implements OrdersService{

    @Autowired
    private OrdersRepository ordersRepository;

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public Optional getById(UUID id) {
        return null;
    }
}
