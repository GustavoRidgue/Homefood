package com.ridgue.homefood.usecase.client;

import com.ridgue.homefood.database.entity.ClientEntity;
import com.ridgue.homefood.database.repository.facade.ClientRepositoryFacade;
import com.ridgue.homefood.http.domain.request.ClientRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteClientUseCase {
    private final ClientRepositoryFacade clientRepositoryFacade;

    public void execute(Long id) throws Exception {
        ClientEntity byId = clientRepositoryFacade.findById(id);
        if (byId == null) throw new Exception("Nonexistent client");

        clientRepositoryFacade.delete(id);
    }
}
