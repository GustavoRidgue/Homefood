package com.ridgue.homefood.http.domain.request;

import com.ridgue.homefood.database.entity.StateEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CityRequest {
    private String name;
    private StateEntity state;
}
