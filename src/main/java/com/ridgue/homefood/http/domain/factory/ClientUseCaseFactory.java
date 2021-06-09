package com.ridgue.homefood.http.domain.factory;

import com.ridgue.homefood.usecase.client.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
@AllArgsConstructor
public class ClientUseCaseFactory {
    private final ListClientUseCase listClientUseCase;
    private final FindClientByIdUseCase findClientByIdUseCase;
    private final CreateClientUseCase createClientUseCase;
    private final UpdateClientUseCase updateClientUseCase;
    private final PatchClientUseCase patchClientUseCase;
    private final DeleteClientUseCase deleteClientUseCase;
    private final GetRegistrationCodeUseCase getRegistrationCodeUseCase;
    private final ActivateClientCodeUseCase activateClientCodeUseCase;
}
