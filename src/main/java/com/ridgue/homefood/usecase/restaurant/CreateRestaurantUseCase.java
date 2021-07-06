package com.ridgue.homefood.usecase.restaurant;

import com.ridgue.homefood.database.entity.RestaurantEntity;
import com.ridgue.homefood.database.repository.facade.RestaurantRepositoryFacade;
import com.ridgue.homefood.exceptions.InvalidFieldException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateRestaurantUseCase {
    private final RestaurantRepositoryFacade facade;

    public long execute(RestaurantEntity restaurant) {
        try {
            return facade.create(restaurant);
        } catch (Exception e) {
            throw new InvalidFieldException();
        }
    }
}