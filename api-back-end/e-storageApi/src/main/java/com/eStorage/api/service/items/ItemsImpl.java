package com.eStorage.api.service.items;


import com.eStorage.api.repository.items.ItemsRepository;
import com.eStorage.api.service.baseService.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ItemsImpl extends BaseServiceImpl {

    @Autowired
    private ItemsRepository itemsRepository;

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public Optional getById(UUID id) {
        return null;
    }
}
