package com.eStorage.api.service.stores;

import com.eStorage.api.repository.stores.StoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StoresServiceImpl implements StoresService {

    @Autowired
    private StoresRepository storesRepository;

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public Optional getById(UUID id) {
        return null;
    }
}
