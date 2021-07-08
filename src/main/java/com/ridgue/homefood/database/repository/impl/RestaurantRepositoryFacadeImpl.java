package com.ridgue.homefood.database.repository.impl;

import com.ridgue.homefood.database.entity.RestaurantEntity;
import com.ridgue.homefood.database.repository.RestaurantRepository;
import com.ridgue.homefood.database.repository.facade.RestaurantRepositoryFacade;
import com.ridgue.homefood.http.domain.request.RestaurantRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class RestaurantRepositoryFacadeImpl implements RestaurantRepositoryFacade {
    private final RestaurantRepository repository;

    @Transactional(readOnly = true)
    public List<RestaurantEntity> findAll() {
        return repository.findAll();
    }

    public RestaurantEntity findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public long create(RestaurantEntity restaurantEntity) {
        return repository.save(restaurantEntity).getId();
    }

    public RestaurantEntity updateById(Long id, RestaurantRequest request) throws Exception {
        RestaurantEntity restaurant = repository.findById(id).get();
        restaurant.setName(request.getName());
        restaurant.setKitchen(request.getKitchen());
        restaurant.setShipping(request.getShipping());
        restaurant.setPaymentMethods(request.getPaymentMethods());
        restaurant.setAddress(request.getAddress());
        restaurant.setLastUpdate(LocalDate.now());

        return restaurant;
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
