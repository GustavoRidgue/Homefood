package com.ridgue.homefood.database.repository.impl;

import com.ridgue.homefood.database.entity.OrderEntity;
import com.ridgue.homefood.database.entity.ProductEntity;
import com.ridgue.homefood.database.repository.ProductRepository;
import com.ridgue.homefood.database.repository.facade.ProductRepositoryFacade;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class ProductRepositoryFacadeImpl implements ProductRepositoryFacade {
    private final ProductRepository repository;

    @Transactional(readOnly = true)
    public List<ProductEntity> findAll() {
        return repository.findAll();
    }

    public ProductEntity findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void create(ProductEntity product) {
        repository.save(product);
    }
}
