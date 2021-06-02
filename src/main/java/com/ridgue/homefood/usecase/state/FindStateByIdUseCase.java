package com.ridgue.homefood.usecase.state;

import com.ridgue.homefood.database.entity.CountryEntity;
import com.ridgue.homefood.database.entity.StateEntity;
import com.ridgue.homefood.database.repository.facade.CountryRepositoryFacade;
import com.ridgue.homefood.database.repository.facade.StateRepositoryFacade;
import com.ridgue.homefood.exceptions.ClientNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindStateByIdUseCase {
    private final StateRepositoryFacade facade;

    public StateEntity execute(Long id) {
        if (facade.findById(id) == null) throw new ClientNotFoundException();
        return facade.findById(id);
    }
}
