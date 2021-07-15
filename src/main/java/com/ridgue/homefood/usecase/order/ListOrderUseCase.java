package com.ridgue.homefood.usecase.order;

import com.ridgue.homefood.database.entity.OrderEntity;
import com.ridgue.homefood.database.entity.RestaurantEntity;
import com.ridgue.homefood.database.repository.facade.OrderRepositoryFacade;
import com.ridgue.homefood.database.repository.facade.RestaurantRepositoryFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ListOrderUseCase {
    private final OrderRepositoryFacade facade;

    public List<OrderEntity> execute() {
        return facade.findAll();
    }
}