package com.ridgue.homefood.http.domain.request;

import com.ridgue.homefood.database.entity.StateEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CountryRequest {
    private String name;
}
