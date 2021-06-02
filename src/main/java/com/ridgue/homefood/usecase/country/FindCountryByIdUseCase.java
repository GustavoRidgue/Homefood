package com.ridgue.homefood.usecase.country;

import com.ridgue.homefood.database.entity.ClientEntity;
import com.ridgue.homefood.database.entity.CountryEntity;
import com.ridgue.homefood.database.repository.facade.ClientRepositoryFacade;
import com.ridgue.homefood.database.repository.facade.CountryRepositoryFacade;
import com.ridgue.homefood.exceptions.ClientNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindCountryByIdUseCase {
    private final CountryRepositoryFacade facade;

    public CountryEntity execute(Long id) {
        if (facade.findById(id) == null) throw new ClientNotFoundException();
        return facade.findById(id);
    }
}
