package com.ridgue.homefood.database.repository.impl;

import com.ridgue.homefood.database.entity.ClientEntity;
import com.ridgue.homefood.database.entity.RestaurantEntity;
import com.ridgue.homefood.database.repository.RestaurantRepository;
import com.ridgue.homefood.database.repository.facade.RestaurantRepositoryFacade;
import com.ridgue.homefood.exceptions.ClientAlreadyActivatedException;
import com.ridgue.homefood.exceptions.ClientNotFoundException;
import com.ridgue.homefood.http.domain.request.RestaurantRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
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
        if (!repository.findById(id).isPresent()) throw new ClientNotFoundException();

        for (Field f : request.getClass().getDeclaredFields()) {
            f.setAccessible(true);

            if (f.get(request) == null || f.get(request).equals("")) throw new IllegalAccessException();
        }


        RestaurantEntity restaurant = repository.findById(id).get();
        restaurant.setName(request.getName());
        restaurant.setKitchen(request.getKitchen());
        restaurant.setShipping(request.getShipping());
        restaurant.setPaymentMethods(request.getPaymentMethods());
        restaurant.setAddress(request.getAddress());
        restaurant.setLastUpdate(LocalDate.now());

        return restaurant;
    }
}
