package com.ridgue.homefood.http.ws;

import com.ridgue.homefood.exceptions.ClientNotFoundException;
import com.ridgue.homefood.exceptions.InvalidClientFieldException;
import com.ridgue.homefood.http.domain.factory.StateBuilderFactory;
import com.ridgue.homefood.http.domain.factory.StateUseCaseFactory;
import com.ridgue.homefood.http.domain.request.ClientRequest;
import com.ridgue.homefood.http.domain.request.StateRequest;
import com.ridgue.homefood.http.domain.response.DefaultResponse;
import com.ridgue.homefood.http.domain.response.client.ClientResponse;
import com.ridgue.homefood.http.domain.response.state.ListStateResponse;
import com.ridgue.homefood.http.domain.response.state.StateResponse;
import com.ridgue.homefood.http.ws.base.URLMapping;
import com.ridgue.homefood.usecase.state.ListStateUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.stream.Collectors;

import static com.ridgue.homefood.http.ws.base.URLMapping.ROOT_API_WS_CLIENT_BY_ID;
import static com.ridgue.homefood.http.ws.base.URLMapping.ROOT_API_WS_STATE_BY_ID;

@RestController
@AllArgsConstructor
@RequestMapping(value = URLMapping.ROOT_API_PATH)
public class StateWS {
    private final StateBuilderFactory stateBuilderFactory;
    private final StateUseCaseFactory stateUseCaseFactory;
    private final ListStateUseCase listStateUseCase;

    /**
     * -----------------------------
     * ------- GET METHODS
     * -----------------------------
     */
    @GetMapping(path = URLMapping.ROOT_API_WS_STATES)
    public ResponseEntity<ListStateResponse> list() {
        return ResponseEntity.ok(new ListStateResponse(listStateUseCase.execute().stream().map(stateBuilderFactory.getStateBuilder()::build).collect(Collectors.toList())));
    }

    @GetMapping(path = ROOT_API_WS_STATE_BY_ID)
    public ResponseEntity<StateResponse> listById(@PathVariable(name = "id") Long id) {
        try {
            return ResponseEntity.ok(new StateResponse(stateBuilderFactory.getStateBuilder().build(stateUseCaseFactory.getFindStateByIdUseCase().execute(id))));
        } catch (ClientNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * -----------------------------
     * ------- POST METHODS
     * -----------------------------
     */
    @PostMapping(path = URLMapping.ROOT_API_WS_STATE_SAVE)
//    @Transactional
    public ResponseEntity<?> create(@RequestBody StateRequest stateRequest, UriComponentsBuilder uriComponentsBuilder) {
        try {
            long id = stateUseCaseFactory.getCreateStateUseCase().execute(stateBuilderFactory.getStateBuilder().build(stateRequest));
            URI uri = uriComponentsBuilder.path(ROOT_API_WS_STATE_BY_ID ).buildAndExpand(id).toUri();

            return ResponseEntity.created(uri).body(stateUseCaseFactory.getFindStateByIdUseCase().execute(id));
        } catch (InvalidClientFieldException e) {
            return new  ResponseEntity<>(new DefaultResponse("ERROR", Arrays.asList(e.getError(), e.getMessage())), HttpStatus.BAD_REQUEST);
        }
    }
}
