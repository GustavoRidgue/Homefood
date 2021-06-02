package com.ridgue.homefood.http.ws;

import com.ridgue.homefood.exceptions.InvalidClientFieldException;
import com.ridgue.homefood.http.domain.factory.CountryBuilderFactory;
import com.ridgue.homefood.http.domain.factory.CountryUseCaseFactory;
import com.ridgue.homefood.http.domain.request.ClientRequest;
import com.ridgue.homefood.http.domain.request.CountryRequest;
import com.ridgue.homefood.http.domain.response.DefaultResponse;
import com.ridgue.homefood.http.domain.response.client.ListClientResponse;
import com.ridgue.homefood.http.domain.response.country.ListCountryResponse;
import com.ridgue.homefood.http.ws.base.URLMapping;
import com.ridgue.homefood.usecase.country.ListCountryUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = URLMapping.ROOT_API_PATH)
public class CountryWS {
    private final CountryBuilderFactory countryBuilderFactory;
    private final CountryUseCaseFactory countryUseCaseFactory;
    private final ListCountryUseCase listCountryUseCase;

    /**
     * -----------------------------
     * ------- GET METHODS
     * -----------------------------
     */
    @GetMapping(path = URLMapping.ROOT_API_WS_COUNTRIES)
    public ResponseEntity<ListCountryResponse> list() {
        return ResponseEntity.ok(new ListCountryResponse(listCountryUseCase.execute().stream().map(countryBuilderFactory.getCountryBuilder()::build).collect(Collectors.toList())));
    }

    @PostMapping(path = URLMapping.ROOT_API_WS_COUNTRY_SAVE)
//    @Transactional
    public ResponseEntity<?> create(@RequestBody CountryRequest countryRequest, UriComponentsBuilder uriComponentsBuilder) {
        try {
            long id = countryUseCaseFactory.getCreateCountryUseCase().execute(countryBuilderFactory.getCountryBuilder().build(countryRequest));
            URI uri = uriComponentsBuilder.path(URLMapping.ROOT_API_WS_CLIENT_BY_ID).buildAndExpand(id).toUri();

            return ResponseEntity.created(uri).body(countryUseCaseFactory.getFindCountryByIdUseCase().execute(id));
        } catch (InvalidClientFieldException e) {
            return new  ResponseEntity<>(new DefaultResponse("ERROR", Arrays.asList(e.getError(), e.getMessage())), HttpStatus.BAD_REQUEST);
        }
    }
}
