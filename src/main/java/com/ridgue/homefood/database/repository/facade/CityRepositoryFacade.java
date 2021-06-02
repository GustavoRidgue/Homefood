package com.ridgue.homefood.database.repository.facade;

import com.ridgue.homefood.database.entity.CityEntity;
import com.ridgue.homefood.database.entity.ClientEntity;
import com.ridgue.homefood.http.domain.request.ClientRequest;

import java.util.List;

public interface CityRepositoryFacade {
    List<CityEntity> findAll();
    CityEntity findById(Long id);
    long create(CityEntity clientEntity);
    void deleteById(Long id);
}
