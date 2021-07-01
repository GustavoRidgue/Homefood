package com.ridgue.homefood.usecase.client;

import com.ridgue.homefood.database.entity.ClientEntity;
import com.ridgue.homefood.database.repository.facade.ClientRepositoryFacade;
import com.ridgue.homefood.exceptions.ClientNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindClientByIdUseCase {
    private final ClientRepositoryFacade facade;

    public ClientEntity execute(Long id) {
        if (facade.findById(id) == null) throw new ClientNotFoundException();
        return facade.findById(id);
    }
}