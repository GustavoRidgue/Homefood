package com.ridgue.homefood.usecase.restaurant;

import com.ridgue.homefood.database.entity.ClientEntity;
import com.ridgue.homefood.database.entity.RestaurantEntity;
import com.ridgue.homefood.database.repository.facade.ClientRepositoryFacade;
import com.ridgue.homefood.database.repository.facade.RestaurantRepositoryFacade;
import com.ridgue.homefood.exceptions.ClientNotFoundException;
import com.ridgue.homefood.exceptions.InvalidFieldException;
import com.ridgue.homefood.http.domain.request.ClientRequest;
import com.ridgue.homefood.http.domain.request.RestaurantRequest;
import lombok.RequiredArgsConstructor;
import org.hibernate.PropertyValueException;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@Component
@RequiredArgsConstructor
public class UpdateRestaurantUseCase {
    private final RestaurantRepositoryFacade facade;

    public RestaurantEntity execute(Long id, RestaurantRequest request) throws Exception {
        try {
            return facade.updateById(id, request);
        } catch (NullPointerException | ClientNotFoundException | IllegalAccessException e) {
            throw new ClientNotFoundException();
        }// catch (Exception e) {
//            System.out.println("catch field null");
//            throw new InvalidFieldException();
//        }

//        return facade.updateById(id, request);

//        try {
//            return facade.updateById(id, request);
//        } catch (PropertyValueException | IllegalAccessException e) {
//            throw new InvalidFieldException();
//        }
    }
}