package com.ridgue.homefood.http.domain.builder;

import com.ridgue.homefood.database.entity.CityEntity;
import com.ridgue.homefood.domain.CityTO;
import com.ridgue.homefood.exceptions.InvalidClientFieldException;
import com.ridgue.homefood.http.domain.request.CityRequest;
import org.springframework.stereotype.Component;

@Component
public class CityBuilder {
    public CityTO build(CityEntity cityEntity) {
        if (cityEntity == null) return null;

        CityTO to = new CityTO();
        to.setId(cityEntity.getId());
        to.setName(cityEntity.getName());

        return to;
    }

    public CityEntity build(CityRequest cityRequest) {
        if (cityRequest == null) return null;

        try {
            CityEntity client = new CityEntity();
            client.setName(cityRequest.getName());

            return client;
        } catch (Exception e) {
            throw new InvalidClientFieldException();
        }
    }
}
