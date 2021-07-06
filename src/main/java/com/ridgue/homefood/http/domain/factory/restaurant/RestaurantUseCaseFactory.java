package com.ridgue.homefood.http.domain.factory.restaurant;

import com.ridgue.homefood.usecase.restaurant.CreateRestaurantUseCase;
import com.ridgue.homefood.usecase.restaurant.FindRestaurantByIdUseCase;
import com.ridgue.homefood.usecase.restaurant.ListRestaurantUseCase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
@AllArgsConstructor
public class RestaurantUseCaseFactory {
    private final ListRestaurantUseCase listRestaurantUseCase;
    private final FindRestaurantByIdUseCase findRestaurantByIdUseCase;
    private final CreateRestaurantUseCase createRestaurantUseCase;
}