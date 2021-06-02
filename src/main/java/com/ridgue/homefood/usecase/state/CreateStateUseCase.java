package com.ridgue.homefood.usecase.state;

import com.ridgue.homefood.database.entity.CountryEntity;
import com.ridgue.homefood.database.entity.StateEntity;
import com.ridgue.homefood.database.repository.facade.CountryRepositoryFacade;
import com.ridgue.homefood.database.repository.facade.StateRepositoryFacade;
import com.ridgue.homefood.exceptions.InvalidClientFieldException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateStateUseCase {
    private final StateRepositoryFacade facade;

    public long execute(StateEntity stateEntity) {
        try {
            return facade.create(stateEntity);
        } catch (Exception e) {
            throw new InvalidClientFieldException();
        }
    }
}
