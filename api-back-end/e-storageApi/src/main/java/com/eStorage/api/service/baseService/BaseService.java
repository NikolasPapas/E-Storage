package com.eStorage.api.service.baseService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BaseService<T> {
    List<T> getAll();
    Optional<T> getById(UUID id);
}
