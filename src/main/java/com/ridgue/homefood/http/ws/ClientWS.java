package com.ridgue.homefood.http.ws;

import com.ridgue.homefood.database.entity.ClientEntity;
import com.ridgue.homefood.exceptions.ClientAlreadyActivatedException;
import com.ridgue.homefood.exceptions.ClientNotFoundException;
import com.ridgue.homefood.exceptions.InvalidClientFieldException;
import com.ridgue.homefood.exceptions.InvalidClientTokenException;
import com.ridgue.homefood.http.domain.factory.client.ClientBuilderFactory;
import com.ridgue.homefood.http.domain.factory.client.ClientUseCaseFactory;
import com.ridgue.homefood.http.domain.request.ClientRequest;
import com.ridgue.homefood.http.domain.response.DefaultResponse;
import com.ridgue.homefood.http.domain.response.client.ClientResponse;
import com.ridgue.homefood.http.domain.response.client.ListClientResponse;
import com.ridgue.homefood.http.ws.base.URLMapping;
import com.ridgue.homefood.http.ws.util.ClientFields;
import com.ridgue.homefood.usecase.client.ListClientUseCase;
import lombok.AllArgsConstructor;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static com.ridgue.homefood.http.ws.base.URLMapping.ROOT_API_WS_CLIENT_ACTIVATE;
import static com.ridgue.homefood.http.ws.base.URLMapping.ROOT_API_WS_CLIENT_BY_ID;

@RestController
@AllArgsConstructor
@RequestMapping(value = URLMapping.ROOT_API_PATH)
public class ClientWS {
    private final ClientBuilderFactory clientBuilderFactory;
    private final ClientUseCaseFactory clientUseCaseFactory;
    private final ListClientUseCase listClientUseCase;

    /**
     * -----------------------------
     * ------- GET METHODS
     * -----------------------------
     */
    @GetMapping(path = URLMapping.ROOT_API_WS_CLIENTS)
    public ResponseEntity<ListClientResponse> list() {
        return ResponseEntity.ok(new ListClientResponse(listClientUseCase.execute().stream().map(clientBuilderFactory.getClientBuilder()::build).collect(Collectors.toList())));
    }

    @GetMapping(path = ROOT_API_WS_CLIENT_BY_ID)
    public ResponseEntity<ClientResponse> listById(@PathVariable(name = "id") Long id) {
        try {
            return ResponseEntity.ok(new ClientResponse(clientBuilderFactory.getClientBuilder().build(clientUseCaseFactory.getFindClientByIdUseCase().execute(id))));
        } catch (ClientNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * -----------------------------
     * ------- POST METHODS
     * -----------------------------
     */
    @PostMapping(path = URLMapping.ROOT_API_WS_CLIENT_SAVE)
//    @Transactional
    public ResponseEntity<?> create(@RequestBody ClientRequest clientRequest, UriComponentsBuilder uriComponentsBuilder) {
        try {
            long id = clientUseCaseFactory.getCreateClientUseCase().execute(clientBuilderFactory.getClientBuilder().build(clientRequest));
            URI uri = uriComponentsBuilder.path(URLMapping.ROOT_API_WS_CLIENT_BY_ID).buildAndExpand(id).toUri();

            return ResponseEntity.created(uri).body(clientUseCaseFactory.getFindClientByIdUseCase().execute(id));
        } catch (InvalidClientFieldException e) {
            return new ResponseEntity<>(new DefaultResponse("ERROR", Arrays.asList(e.getError(), e.getMessage())), HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * -----------------------------
     * ------- PUT METHODS
     * -----------------------------
     */
    @PutMapping(path = URLMapping.ROOT_API_WS_CLIENT_UPDATE)
    @Transactional
    public ResponseEntity<?> updateById(@PathVariable(name = "id") Long id, @RequestBody ClientRequest clientRequest) {
        try {
            ClientEntity updatedClient = clientUseCaseFactory.getUpdateClientUseCase().execute(id, clientRequest);
            return ResponseEntity.ok(updatedClient);
        } catch (ClientNotFoundException e) {
            return new ResponseEntity<>(new DefaultResponse("ERROR", Arrays.asList(e.getError(), e.getMessage())), HttpStatus.NOT_FOUND);
        } catch (InvalidClientFieldException e) {
            return new ResponseEntity<>(new DefaultResponse("ERROR", Arrays.asList(e.getError(), e.getMessage())), HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * -----------------------------
     * ------- PATCH METHODS
     * -----------------------------
     */
    @PatchMapping(path = URLMapping.ROOT_API_WS_CLIENT_UPDATE)
    @Transactional
    public ResponseEntity<?> patchById(@PathVariable(name = "id") Long id, @RequestBody Map<ClientFields, Object> fields) {
        try {
            ClientEntity clientEntity = clientUseCaseFactory.getPatchClientUseCase().execute(id, fields);
            return ResponseEntity.ok(clientEntity);
        } catch (JsonParseException e) {
            System.out.println("hjfb ehrjw");
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * -----------------------------
     * ------- DELETE METHODS
     * -----------------------------
     */
    @DeleteMapping(path = URLMapping.ROOT_API_WS_CLIENT_DELETE)
//    @Transactional
    public ResponseEntity<?> deleteById(@PathVariable(name = "id") Long id) {
        try {
            ClientEntity execute = clientUseCaseFactory.getFindClientByIdUseCase().execute(id);
            clientUseCaseFactory.getDeleteClientUseCase().execute(execute.getId());
//            return new ResponseEntity<>(new DefaultResponse(Collections.singletonList("Client successfully deleted")), HttpStatus.OK);
            return new ResponseEntity<>(new DefaultResponse(), HttpStatus.NO_CONTENT);
        } catch (ClientNotFoundException e) {
            return new ResponseEntity<>(new DefaultResponse("ERROR", Arrays.asList(e.getError(), e.getMessage())), HttpStatus.NOT_FOUND);
        }
    }

    /**
     * -----------------------------
     * ------- SERVICE
     * -----------------------------
     */

    @PatchMapping(path = URLMapping.ROOT_API_WS_CLIENT_GET_REGISTRATION_CODE)
    @Transactional
    public ResponseEntity<?> receiveRegistrationCode(@PathVariable(name = "id") Long id) {
        try {
            String token = clientUseCaseFactory.getGetRegistrationCodeUseCase().execute(id, ROOT_API_WS_CLIENT_ACTIVATE + id);
            return new ResponseEntity<>(token, HttpStatus.OK);
        } catch (ClientAlreadyActivatedException e) {
            return new ResponseEntity<>(new DefaultResponse("ERROR", Arrays.asList(e.getError(), e.getMessage())), HttpStatus.BAD_REQUEST);
        } catch (ClientNotFoundException e) {
            return new ResponseEntity<>(new DefaultResponse("ERROR", Arrays.asList(e.getError(), e.getMessage())), HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping(path = ROOT_API_WS_CLIENT_ACTIVATE)
    @Transactional
    public ResponseEntity<?> activate(@PathVariable(name = "id") Long id, @RequestParam String token) {
        try {
            ClientEntity execute = clientUseCaseFactory.getActivateClientCodeUseCase().execute(id, token);
            return new ResponseEntity<>(execute, HttpStatus.OK);
        } catch (ClientAlreadyActivatedException e) {
            return new ResponseEntity<>(new DefaultResponse("ERROR", Arrays.asList(e.getError(), e.getMessage())), HttpStatus.BAD_REQUEST);
        } catch (InvalidClientTokenException e) {
            return new ResponseEntity<>(new DefaultResponse("ERROR", Arrays.asList(e.getError(), e.getMessage())), HttpStatus.BAD_REQUEST);
        } catch (ClientNotFoundException e) {
            return new ResponseEntity<>(new DefaultResponse("ERROR", Arrays.asList(e.getError(), e.getMessage())), HttpStatus.BAD_REQUEST);
        }
    }

    //Client received email if code
    //Add redirection header

    //Client register himself with the code in another endpoint
    //Endpoint to client put his registration code to activate account
}