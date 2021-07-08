package com.ridgue.homefood.usecase.restaurant;

import com.ridgue.homefood.database.entity.RestaurantEntity;
import com.ridgue.homefood.database.repository.facade.RestaurantRepositoryFacade;
import com.ridgue.homefood.exceptions.ResourceNotFoundException;
import com.ridgue.homefood.exceptions.InvalidFieldException;
import com.ridgue.homefood.http.domain.request.RestaurantRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
@RequiredArgsConstructor
public class UpdateRestaurantUseCase {
    private final RestaurantRepositoryFacade facade;

    public RestaurantEntity execute(Long id, RestaurantRequest request) throws Exception {
        if (facade.findById(id) == null) throw new ResourceNotFoundException();

        for (Field f : request.getClass().getDeclaredFields()) {
            f.setAccessible(true);

            if (f.get(request) == null || f.get(request).equals("")) throw new InvalidFieldException();
        }

        return facade.updateById(id, request);
    }
}