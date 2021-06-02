package com.ridgue.homefood.usecase.city;

import com.ridgue.homefood.database.entity.CityEntity;
import com.ridgue.homefood.database.entity.ClientEntity;
import com.ridgue.homefood.database.repository.facade.CityRepositoryFacade;
import com.ridgue.homefood.database.repository.facade.ClientRepositoryFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ListCityUseCase {
    private final CityRepositoryFacade facade;

    public List<CityEntity> execute() {
        return facade.findAll();
    }
}
