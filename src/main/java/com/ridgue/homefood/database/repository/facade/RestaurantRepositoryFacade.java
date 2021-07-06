package com.ridgue.homefood.database.repository.facade;

import com.ridgue.homefood.database.entity.RestaurantEntity;

import java.util.List;

public interface RestaurantRepositoryFacade {
    List<RestaurantEntity> findAll();

    RestaurantEntity findById(Long id);
}
