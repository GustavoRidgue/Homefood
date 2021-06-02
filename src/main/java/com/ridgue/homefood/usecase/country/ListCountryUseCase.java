package com.ridgue.homefood.usecase.country;

import com.ridgue.homefood.database.entity.ClientEntity;
import com.ridgue.homefood.database.entity.CountryEntity;
import com.ridgue.homefood.database.repository.facade.ClientRepositoryFacade;
import com.ridgue.homefood.database.repository.facade.CountryRepositoryFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ListCountryUseCase {
    private final CountryRepositoryFacade facade;

    public List<CountryEntity> execute() {
        return facade.findAll();
    }
}
