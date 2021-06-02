package com.ridgue.homefood.usecase.country;

import com.ridgue.homefood.database.entity.ClientEntity;
import com.ridgue.homefood.database.entity.CountryEntity;
import com.ridgue.homefood.database.repository.facade.ClientRepositoryFacade;
import com.ridgue.homefood.database.repository.facade.CountryRepositoryFacade;
import com.ridgue.homefood.exceptions.InvalidClientFieldException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateCountryUseCase {
    private final CountryRepositoryFacade countryRepositoryFacade;

    public long execute(CountryEntity countryEntity) {
        try {
            return countryRepositoryFacade.create(countryEntity);
        } catch (Exception e) {
            throw new InvalidClientFieldException();
        }
    }
}
