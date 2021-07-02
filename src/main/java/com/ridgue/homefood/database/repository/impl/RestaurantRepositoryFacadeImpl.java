package com.ridgue.homefood.database.repository.impl;

import com.ridgue.homefood.database.entity.RestaurantEntity;
import com.ridgue.homefood.database.repository.RestaurantRepository;
import com.ridgue.homefood.database.repository.facade.RestaurantRepositoryFacade;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class RestaurantRepositoryFacadeImpl implements RestaurantRepositoryFacade {
    private final RestaurantRepository repository;

    @Transactional(readOnly = true)
    public List<RestaurantEntity> findAll() {
        return repository.findAll();
    }
}
