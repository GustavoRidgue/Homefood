package com.ridgue.homefood.http.domain.response.city;

import com.ridgue.homefood.domain.CityTO;
import com.ridgue.homefood.domain.CountryTO;
import com.ridgue.homefood.http.domain.response.DefaultResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class ListCityResponse extends DefaultResponse {
    private List<CityTO> cityTO;
}
