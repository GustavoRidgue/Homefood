package com.ridgue.homefood.http.domain.response.client;

import com.ridgue.homefood.domain.ClientTO;
import com.ridgue.homefood.http.domain.response.DefaultResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class ClientResponse extends DefaultResponse {
    private ClientTO clientTO;
}