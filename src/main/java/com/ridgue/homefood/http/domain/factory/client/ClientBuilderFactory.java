package com.ridgue.homefood.http.domain.factory.client;

import com.ridgue.homefood.http.domain.builder.ClientBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
@AllArgsConstructor
public class ClientBuilderFactory {
    private final ClientBuilder clientBuilder;
//    private final ClientUseCaseFactory clientUseCaseFactory;
}
