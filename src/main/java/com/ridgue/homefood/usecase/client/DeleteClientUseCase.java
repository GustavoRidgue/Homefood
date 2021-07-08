package com.ridgue.homefood.usecase.client;

import com.ridgue.homefood.database.repository.facade.ClientRepositoryFacade;
import com.ridgue.homefood.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.hibernate.PropertyValueException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteClientUseCase {
    private final ClientRepositoryFacade clientRepositoryFacade;

    public void execute(Long id) {
        try {
            clientRepositoryFacade.deleteById(id);
        } catch (EmptyResultDataAccessException | PropertyValueException e) {
            throw new ResourceNotFoundException();
        }
    }
}