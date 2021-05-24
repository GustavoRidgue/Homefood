package com.ridgue.homefood.http.domain.response;

import com.ridgue.homefood.domain.ClientTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class ListClientResponse extends DefaultResponse {
    private List<ClientTO> clientTO;
}
