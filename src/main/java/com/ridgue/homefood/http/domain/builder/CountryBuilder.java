package com.ridgue.homefood.http.domain.builder;

import com.ridgue.homefood.database.entity.CountryEntity;
import com.ridgue.homefood.domain.CountryTO;
import com.ridgue.homefood.exceptions.InvalidClientFieldException;
import com.ridgue.homefood.http.domain.request.CountryRequest;
import org.springframework.stereotype.Component;

@Component
public class CountryBuilder {
    public CountryTO build(CountryEntity countryEntity) {
        if (countryEntity == null) return null;

        CountryTO to = new CountryTO();
        to.setId(countryEntity.getId());
        to.setName(countryEntity.getName());

        return to;
    }

    public CountryEntity build(CountryRequest countryRequest) {
        if (countryRequest == null) return null;

        try {
            CountryEntity country = new CountryEntity();
            country.setName(countryRequest.getName());

            return country;
        } catch (Exception e) {
            throw new InvalidClientFieldException();
        }
    }
}
