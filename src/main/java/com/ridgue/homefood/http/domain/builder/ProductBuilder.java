package com.ridgue.homefood.http.domain.builder;

import com.ridgue.homefood.database.entity.ProductEntity;
import com.ridgue.homefood.domain.ProductTO;
import com.ridgue.homefood.domain.RestaurantTO;
import com.ridgue.homefood.http.domain.request.ProductRequest;
import com.ridgue.homefood.http.domain.request.RestaurantRequest;
import org.springframework.stereotype.Component;

@Component
public class ProductBuilder {
    public ProductTO build(ProductEntity product) {
        if (product == null) return null;

        ProductTO to = new ProductTO();
        to.setId(product.getId());
        to.setName(product.getName());
        to.setDescription(product.getDescription());
        to.setPrice(product.getPrice());
        to.setActive(product.getActive());
        to.setRestaurant(product.getRestaurant().getName());

        return to;
    }

    public ProductEntity build(ProductRequest request) {
        if (request == null) return null;

        ProductEntity restaurant = new ProductEntity();
        restaurant.setName(request.getName());
        restaurant.setDescription(request.getDescription());
        restaurant.setPrice(request.getPrice());
        restaurant.setRestaurant(request.getRestaurant());
        restaurant.setActive(true);

        return restaurant;
    }
}
