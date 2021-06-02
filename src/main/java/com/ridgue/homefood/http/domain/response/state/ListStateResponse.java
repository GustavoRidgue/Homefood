package com.ridgue.homefood.http.domain.response.state;

import com.ridgue.homefood.domain.CountryTO;
import com.ridgue.homefood.domain.StateTO;
import com.ridgue.homefood.http.domain.response.DefaultResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class ListStateResponse extends DefaultResponse {
    private List<StateTO> stateTO;
}
