package com.ridgue.homefood.usecase.product;

import com.ridgue.homefood.database.entity.ProductEntity;
import com.ridgue.homefood.database.entity.RestaurantEntity;
import com.ridgue.homefood.database.repository.facade.ProductRepositoryFacade;
import com.ridgue.homefood.database.repository.facade.RestaurantRepositoryFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ListProductUseCase {
    private final ProductRepositoryFacade facade;

    public List<ProductEntity> execute() {
        return facade.findAll();
    }
}