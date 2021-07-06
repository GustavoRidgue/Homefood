package com.ridgue.homefood.usecase.client;

import com.ridgue.homefood.database.entity.ClientEntity;
import com.ridgue.homefood.database.repository.facade.ClientRepositoryFacade;
import com.ridgue.homefood.exceptions.InvalidFieldException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateClientUseCase {
    private final ClientRepositoryFacade clientRepositoryFacade;

    public long execute(ClientEntity clientEntity) {
        try {
            return clientRepositoryFacade.create(clientEntity);
        } catch (Exception e) {
            throw new InvalidFieldException();
        }
    }
}