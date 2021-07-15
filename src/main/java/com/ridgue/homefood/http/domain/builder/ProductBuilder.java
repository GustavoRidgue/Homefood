package com.ridgue.homefood.http.domain.builder;

import com.ridgue.homefood.database.entity.ProductEntity;
import com.ridgue.homefood.database.entity.RestaurantEntity;
import com.ridgue.homefood.domain.ProductTO;
import com.ridgue.homefood.domain.RestaurantTO;
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

    public RestaurantEntity build(RestaurantRequest restaurantRequest) {
        if (restaurantRequest == null) return null;

        RestaurantEntity restaurant = new RestaurantEntity();
        restaurant.setName(restaurantRequest.getName());
        restaurant.setKitchen(restaurantRequest.getKitchen());
        restaurant.setShipping(restaurantRequest.getShipping());
        restaurant.setPaymentMethods(restaurantRequest.getPaymentMethods());
        restaurant.setAddress(restaurantRequest.getAddress());

        return restaurant;
    }
}
