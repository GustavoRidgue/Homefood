package com.ridgue.homefood.database.repository.impl;

import com.ridgue.homefood.database.entity.RestaurantEntity;
import com.ridgue.homefood.database.repository.RestaurantRepository;
import com.ridgue.homefood.database.repository.facade.OrderRepositoryFacade;
import com.ridgue.homefood.database.repository.facade.RestaurantRepositoryFacade;
import com.ridgue.homefood.http.domain.request.RestaurantRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class OrderRepositoryFacadeImpl implements OrderRepositoryFacade {
    private final RestaurantRepository repository;

    @Transactional(readOnly = true)
    public List<RestaurantEntity> findAll() {
        return repository.findAll();
    }
}
