package com.ridgue.homefood.http.domain.factory;

import com.ridgue.homefood.http.domain.builder.ClientBuilder;
import com.ridgue.homefood.http.domain.builder.StateBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
@AllArgsConstructor
public class StateBuilderFactory {
    private final StateBuilder stateBuilder;
}
