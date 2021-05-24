package com.ridgue.homefood.http.controller;

import com.ridgue.homefood.database.entity.ClientEntity;
import com.ridgue.homefood.http.controller.base.URLMapping;
import com.ridgue.homefood.http.domain.factory.ClientBuilderFactory;
import com.ridgue.homefood.http.domain.factory.ClientUseCaseFactory;
import com.ridgue.homefood.http.domain.request.ClientRequest;
import com.ridgue.homefood.http.domain.response.ClientResponse;
import com.ridgue.homefood.http.domain.response.DefaultResponse;
import com.ridgue.homefood.http.domain.response.ListClientResponse;
import com.ridgue.homefood.usecase.client.CreateClientUseCase;
import com.ridgue.homefood.usecase.client.FindClientByIdUseCase;
import com.ridgue.homefood.usecase.client.ListClientUseCase;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = URLMapping.ROOT_API_PATH)
public class ClientWS {
    private final ClientBuilderFactory clientBuilderFactory;
    private final ClientUseCaseFactory clientUseCaseFactory;
    private final ListClientUseCase listClientUseCase;
    private final FindClientByIdUseCase findClientByIdUseCase;
    private final CreateClientUseCase createClientUseCase;

    /**
     * -----------------------------
     * ------- GET METHODS
     * -----------------------------
     */
    @GetMapping(path = URLMapping.ROOT_API_WS_CLIENTS)
    public ResponseEntity<ListClientResponse> listClients() {
        return ResponseEntity.ok(new ListClientResponse(listClientUseCase.execute().stream().map(clientBuilderFactory.getClientBuilder()::build).collect(Collectors.toList())));
    }

    @GetMapping(path = URLMapping.ROOT_API_WS_CLIENT_BY_ID)
    public ResponseEntity<ClientResponse> getClientById(@PathVariable(name = "id") Long id) {
        if (findClientByIdUseCase.execute(id) == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(new ClientResponse(clientBuilderFactory.getClientBuilder().build(clientUseCaseFactory.getFindClientByIdUseCase().execute(id))));
    }

    /**
     * -----------------------------
     * ------- POST METHODS
     * -----------------------------
     */
    @PostMapping(path = URLMapping.ROOT_API_WS_CLIENT_SAVE)
    @Transactional
    public ResponseEntity<?> createClient(@RequestBody ClientRequest clientRequest, UriComponentsBuilder uriComponentsBuilder) {
        createClientUseCase.execute(clientRequest);

        long id = clientUseCaseFactory.getCreateClientUseCase().execute(clientRequest);

        URI uri = uriComponentsBuilder.path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).body(new DefaultResponse());
    }

    /**
     * -----------------------------
     * ------- PUT METHODS
     * -----------------------------
     */
    @PutMapping(path = URLMapping.ROOT_API_WS_CLIENT_UPDATE)
    @Transactional
    public ResponseEntity<?> updateClient(@PathVariable(name = "id", required = true) Long id, @RequestBody ClientRequest clientRequest) throws Exception {
        clientUseCaseFactory.getUpdateClientUseCase().execute(id, clientRequest);

        return new ResponseEntity<>(new DefaultResponse(), HttpStatus.OK);
    }

    /**
     * -----------------------------
     * ------- DELETE METHODS
     * -----------------------------
     */
    @DeleteMapping(path = URLMapping.ROOT_API_WS_CLIENT_DELETE)
    @Transactional
    public ResponseEntity<?> createClient(@RequestParam(name = "id", required = true) Long id) throws Exception {
        clientUseCaseFactory.getDeleteClientUseCase().execute(id);

        return new ResponseEntity<>(new DefaultResponse(), HttpStatus.NO_CONTENT);
    }

    /*
    O que é um produto?

    Limite global é um produto sendo testado
    Qlaq contrado de veiculos de leves prsados motos
    ao realizar financiamento, vai ter um contrato mae (embloba financiamento veiculo)
    e fihlo (direiro ao  limite global) disponibilizando um cartçao de crédito com limite de 5% da sua garantia se vc quiser

    o que é a garantia?

    preciso de dinheiro que não tenho. peco dinheiro emprestado, e vou pagando as parcelas com juros
    mas a financeira faz uma analize da pessoa e n dá um valor alto, pra não correr risco de calote.

    mesmo se o cara não pagar, vem a garantia, que gira em torno do financiamento
    a garantia é um bem proprio



    */
}