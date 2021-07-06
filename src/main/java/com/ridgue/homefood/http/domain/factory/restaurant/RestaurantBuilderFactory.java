package com.ridgue.homefood.http.domain.factory.restaurant;

import com.ridgue.homefood.http.domain.builder.RestaurantBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
@AllArgsConstructor
public class RestaurantBuilderFactory {
    private final RestaurantBuilder restaurantBuilder;
}
