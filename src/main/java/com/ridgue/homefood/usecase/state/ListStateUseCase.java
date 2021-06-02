package com.ridgue.homefood.usecase.state;

import com.ridgue.homefood.database.entity.ClientEntity;
import com.ridgue.homefood.database.entity.StateEntity;
import com.ridgue.homefood.database.repository.facade.ClientRepositoryFacade;
import com.ridgue.homefood.database.repository.facade.StateRepositoryFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ListStateUseCase {
    private final StateRepositoryFacade facade;

    public List<StateEntity> execute() {
        return facade.findAll();
    }
}
