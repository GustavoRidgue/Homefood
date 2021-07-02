package com.ridgue.homefood.usecase.restaurant;

import com.ridgue.homefood.database.entity.ClientEntity;
import com.ridgue.homefood.database.entity.RestaurantEntity;
import com.ridgue.homefood.database.repository.facade.ClientRepositoryFacade;
import com.ridgue.homefood.database.repository.facade.RestaurantRepositoryFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ListRestaurantUseCase {
    private final RestaurantRepositoryFacade facade;

    public List<RestaurantEntity> execute() {
        return facade.findAll();
    }
}