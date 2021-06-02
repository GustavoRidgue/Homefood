package com.ridgue.homefood.http.domain.factory;

import com.ridgue.homefood.usecase.client.*;
import com.ridgue.homefood.usecase.country.ListCountryUseCase;
import com.ridgue.homefood.usecase.state.CreateStateUseCase;
import com.ridgue.homefood.usecase.state.FindStateByIdUseCase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
@AllArgsConstructor
public class StateUseCaseFactory {
    private final ListCountryUseCase listCountryUseCase;
    private final FindStateByIdUseCase findStateByIdUseCase;
    private final CreateStateUseCase createStateUseCase;
}
