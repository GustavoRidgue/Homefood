package com.ridgue.homefood.http.domain.builder;

import com.ridgue.homefood.database.entity.ClientEntity;
import com.ridgue.homefood.database.entity.RestaurantEntity;
import com.ridgue.homefood.domain.RestaurantTO;
import com.ridgue.homefood.exceptions.InvalidClientFieldException;
import com.ridgue.homefood.http.domain.request.ClientRequest;
import com.ridgue.homefood.http.domain.request.RestaurantRequest;
import org.springframework.stereotype.Component;

@Component
public class RestaurantBuilder {
    public RestaurantTO build(RestaurantEntity restaurantEntity) {
        if (restaurantEntity == null) return null;

        RestaurantTO to = new RestaurantTO();
        to.setId(restaurantEntity.getId());
        to.setName(restaurantEntity.getName());

        return to;
    }

    public RestaurantEntity build(RestaurantRequest restaurantRequest) {
        if (restaurantRequest == null) return null;

        RestaurantEntity restaurant = new RestaurantEntity();
        restaurant.setName(restaurantRequest.getName());

        return restaurant;
    }
}
