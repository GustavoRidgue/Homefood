package com.ridgue.homefood.usecase.restaurant;

import com.ridgue.homefood.database.entity.RestaurantEntity;
import com.ridgue.homefood.database.repository.facade.RestaurantRepositoryFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindRestaurantByIdUseCase {
    private final RestaurantRepositoryFacade facade;

    public RestaurantEntity execute(Long id) {
        if (facade.findById(id) == null) throw new NullPointerException();
        return facade.findById(id);
    }
}