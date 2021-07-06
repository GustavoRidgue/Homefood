package com.ridgue.homefood.usecase.restaurant;

import com.ridgue.homefood.database.entity.ClientEntity;
import com.ridgue.homefood.database.entity.RestaurantEntity;
import com.ridgue.homefood.database.repository.facade.ClientRepositoryFacade;
import com.ridgue.homefood.database.repository.facade.RestaurantRepositoryFacade;
import com.ridgue.homefood.exceptions.ClientNotFoundException;
import javassist.NotFoundException;
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