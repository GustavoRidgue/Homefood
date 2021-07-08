package com.ridgue.homefood.usecase.restaurant;

import com.ridgue.homefood.database.repository.facade.RestaurantRepositoryFacade;
import com.ridgue.homefood.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteRestaurantUseCase {
    private final RestaurantRepositoryFacade facade;

    public void execute(Long id) {
        if (facade.findById(id) == null) throw new ResourceNotFoundException();
        facade.deleteById(id);
    }
}