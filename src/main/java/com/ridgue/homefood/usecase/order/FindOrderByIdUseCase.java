package com.ridgue.homefood.usecase.order;

import com.ridgue.homefood.database.entity.OrderEntity;
import com.ridgue.homefood.database.entity.RestaurantEntity;
import com.ridgue.homefood.database.repository.facade.OrderRepositoryFacade;
import com.ridgue.homefood.database.repository.facade.RestaurantRepositoryFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindOrderByIdUseCase {
    private final OrderRepositoryFacade facade;

    public OrderEntity execute(Long id) {
        if (facade.findById(id) == null) throw new NullPointerException();
        return facade.findById(id);
    }
}