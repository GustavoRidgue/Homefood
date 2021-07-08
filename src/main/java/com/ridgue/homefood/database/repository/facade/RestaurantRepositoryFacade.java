package com.ridgue.homefood.database.repository.facade;

import com.ridgue.homefood.database.entity.RestaurantEntity;
import com.ridgue.homefood.http.domain.request.RestaurantRequest;

import java.util.List;

public interface RestaurantRepositoryFacade {
    List<RestaurantEntity> findAll();
    RestaurantEntity findById(Long id);
    long create(RestaurantEntity restaurantEntity);
    RestaurantEntity updateById(Long id, RestaurantRequest request) throws Exception;
    void deleteById(Long id);
}
