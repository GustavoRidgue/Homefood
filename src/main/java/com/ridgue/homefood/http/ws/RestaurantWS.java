package com.ridgue.homefood.http.ws;

import com.ridgue.homefood.exceptions.InvalidFieldException;
import com.ridgue.homefood.http.domain.factory.restaurant.RestaurantBuilderFactory;
import com.ridgue.homefood.http.domain.factory.restaurant.RestaurantUseCaseFactory;
import com.ridgue.homefood.http.domain.request.RestaurantRequest;
import com.ridgue.homefood.http.domain.response.DefaultResponse;
import com.ridgue.homefood.http.domain.response.restaurant.ListRestaurantResponse;
import com.ridgue.homefood.http.domain.response.restaurant.RestaurantResponse;
import com.ridgue.homefood.http.ws.base.URLMapping;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.stream.Collectors;

import static com.ridgue.homefood.http.ws.base.URLMapping.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = URLMapping.ROOT_API_PATH)
public class RestaurantWS {
    private final RestaurantUseCaseFactory restaurantUseCaseFactory;
    private final RestaurantBuilderFactory restaurantBuilderFactory;

    /**
     * -----------------------------
     * ------- GET METHODS
     * -----------------------------
     */
    @GetMapping(path = ROOT_API_WS_RESTAURANT)
    public ResponseEntity<ListRestaurantResponse> list() {
        return ResponseEntity.ok(new ListRestaurantResponse(
                restaurantUseCaseFactory.getListRestaurantUseCase().execute().stream().map(
                        restaurantBuilderFactory.getRestaurantBuilder()::build).collect(Collectors.toList())));
    }

    @GetMapping(path = ROOT_API_WS_RESTAURANT_BY_ID)
    public ResponseEntity<RestaurantResponse> listById(@PathVariable(name = "id") Long id) {
        try {
            return ResponseEntity.ok(new RestaurantResponse(restaurantBuilderFactory.getRestaurantBuilder().build(restaurantUseCaseFactory.getFindRestaurantByIdUseCase().execute(id))));
        } catch (NullPointerException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * -----------------------------
     * ------- POST METHODS
     * -----------------------------
     */
    @PostMapping(path = ROOT_API_WS_SAVE_RESTAURANT)
//    @Transactional
    public ResponseEntity<?> create(@RequestBody RestaurantRequest restaurantRequest, UriComponentsBuilder uriComponentsBuilder) {
        try {
            long id = restaurantUseCaseFactory.getCreateRestaurantUseCase().execute(restaurantBuilderFactory.getRestaurantBuilder().build(restaurantRequest));
            URI uri = uriComponentsBuilder.path(URLMapping.ROOT_API_WS_RESTAURANT_BY_ID + id).buildAndExpand(id).toUri();

            return ResponseEntity.created(uri).body(restaurantUseCaseFactory.getFindRestaurantByIdUseCase().execute(id));
        } catch (InvalidFieldException e) {
            return new ResponseEntity<>(new DefaultResponse("ERROR", Arrays.asList(e.getError(), e.getMessage())), HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * -----------------------------
     * ------- UPDATE METHODS
     * -----------------------------
     */

    /**
     * -----------------------------
     * ------- DELETE METHODS
     * -----------------------------
     */
}