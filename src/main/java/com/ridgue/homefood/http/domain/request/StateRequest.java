package com.ridgue.homefood.http.domain.request;

import com.ridgue.homefood.database.entity.CountryEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StateRequest {
    private String name;
    private CountryEntity countryEntity;
}
