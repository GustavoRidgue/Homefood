package com.ridgue.homefood.usecase.product;

import com.ridgue.homefood.database.entity.ProductEntity;
import com.ridgue.homefood.database.entity.RestaurantEntity;
import com.ridgue.homefood.database.repository.facade.ProductRepositoryFacade;
import com.ridgue.homefood.database.repository.facade.RestaurantRepositoryFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindProductByIdUseCase {
    private final ProductRepositoryFacade facade;

    public ProductEntity execute(Long id) {
        if (facade.findById(id) == null) throw new NullPointerException();
        return facade.findById(id);
    }
}