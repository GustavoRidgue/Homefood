package com.ridgue.homefood.domain;

import com.ridgue.homefood.database.entity.StateEntity;
import lombok.Data;
//import lombok.NoArgsConstructor;

@Data
//@NoArgsConstructor
public class CityTO {
    private Long id;
    private String name;
    private StateEntity state;
}
