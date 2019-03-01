package com.eStorage.api.service.baseService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BaseServiceImpl<T> implements BaseService<T>{


    @Override
    public List<T> getAll() {
        return null;
    }

    @Override
    public Optional<T> getById(UUID id) {
        return Optional.empty();
    }
}
