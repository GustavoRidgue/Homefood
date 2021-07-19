package com.ridgue.homefood.database.repository.facade;

import com.ridgue.homefood.database.entity.ProductEntity;

import java.util.List;

public interface ProductRepositoryFacade {
    List<ProductEntity> findAll();
    ProductEntity findById(Long id);

    void create(ProductEntity product);
}
