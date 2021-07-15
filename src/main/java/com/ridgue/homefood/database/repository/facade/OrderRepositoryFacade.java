package com.ridgue.homefood.database.repository.facade;

import com.ridgue.homefood.database.entity.RestaurantEntity;
import com.ridgue.homefood.http.domain.request.RestaurantRequest;

import java.util.List;

public interface OrderRepositoryFacade {
    List<RestaurantEntity> findAll();
}
