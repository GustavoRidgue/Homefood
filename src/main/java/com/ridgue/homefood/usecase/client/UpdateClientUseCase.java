package com.ridgue.homefood.usecase.client;

import com.ridgue.homefood.database.entity.ClientEntity;
import com.ridgue.homefood.database.repository.facade.ClientRepositoryFacade;
import com.ridgue.homefood.exceptions.ResourceNotFoundException;
import com.ridgue.homefood.exceptions.InvalidFieldException;
import com.ridgue.homefood.http.domain.request.ClientRequest;
import lombok.RequiredArgsConstructor;
import org.hibernate.PropertyValueException;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@Component
@RequiredArgsConstructor
public class UpdateClientUseCase {
    private final ClientRepositoryFacade clientRepositoryFacade;

    public ClientEntity execute(Long id, ClientRequest clientRequest) {
        if (clientRequest.getName() == null || clientRequest.getAge() == 0 ||
                clientRequest.getEmail() == null || clientRequest.getPhoneNumber() == null) throw new InvalidFieldException();
        try {
            return clientRepositoryFacade.updateById(id, clientRequest);
        } catch (NullPointerException | EntityNotFoundException e) {
            throw new ResourceNotFoundException();
        } catch (PropertyValueException e) {
            throw new InvalidFieldException();
        }
    }

    public void execute(ClientEntity clientEntity, Long id) {
        clientEntity.setId(id);
    }
}