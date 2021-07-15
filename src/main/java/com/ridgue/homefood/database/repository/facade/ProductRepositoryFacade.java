package com.ridgue.homefood.database.repository.facade;

import com.ridgue.homefood.database.entity.ProductEntity;
import com.ridgue.homefood.database.entity.RestaurantEntity;
import com.ridgue.homefood.http.domain.request.RestaurantRequest;

import java.util.List;

public interface ProductRepositoryFacade {
    List<ProductEntity> findAll();
}
