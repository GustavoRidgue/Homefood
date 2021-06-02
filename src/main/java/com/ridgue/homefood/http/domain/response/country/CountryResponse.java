package com.ridgue.homefood.http.domain.response.country;

import com.ridgue.homefood.domain.ClientTO;
import com.ridgue.homefood.domain.CountryTO;
import com.ridgue.homefood.http.domain.response.DefaultResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

//import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class CountryResponse extends DefaultResponse {
    private CountryTO countryTO;
}
