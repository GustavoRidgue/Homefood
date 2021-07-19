package com.ridgue.homefood.usecase.product;

import com.ridgue.homefood.database.entity.ProductEntity;
import com.ridgue.homefood.database.entity.RestaurantEntity;
import com.ridgue.homefood.database.repository.facade.ProductRepositoryFacade;
import com.ridgue.homefood.database.repository.facade.RestaurantRepositoryFacade;
import com.ridgue.homefood.exceptions.InvalidFieldException;
import com.ridgue.homefood.http.domain.request.ProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateProductUseCase {
    private final ProductRepositoryFacade facade;

    public ProductEntity execute(ProductRequest request) {
        try {
            ProductEntity productEntity = new ProductEntity();
            productEntity.setName(request.getName());
            productEntity.setDescription(request.getDescription());
            productEntity.setPrice(request.getPrice());
            productEntity.setRestaurant(request.getRestaurant());
            productEntity.setActive(true);

            facade.create(productEntity);

            return productEntity;
        } catch (Exception e) {
            throw new InvalidFieldException();
        }
    }
}