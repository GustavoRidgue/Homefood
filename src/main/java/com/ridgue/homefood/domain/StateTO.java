package com.ridgue.homefood.domain;

import com.ridgue.homefood.database.entity.CountryEntity;
import lombok.Data;
//import lombok.NoArgsConstructor;

@Data
//@NoArgsConstructor
public class StateTO {
    private Long id;
    private String name;
    private CountryEntity country;
}
