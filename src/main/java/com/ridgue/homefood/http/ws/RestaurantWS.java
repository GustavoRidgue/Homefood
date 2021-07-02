package com.ridgue.homefood.http.ws;

import com.ridgue.homefood.http.domain.builder.RestaurantBuilder;
import com.ridgue.homefood.http.domain.factory.restaurant.RestaurantBuilderFactory;
import com.ridgue.homefood.http.domain.factory.restaurant.RestaurantUseCaseFactory;
import com.ridgue.homefood.http.domain.response.restaurant.ListRestaurantResponse;
import com.ridgue.homefood.http.ws.base.URLMapping;
import com.ridgue.homefood.usecase.restaurant.ListRestaurantUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = URLMapping.ROOT_API_PATH)
public class RestaurantWS {
    private final RestaurantUseCaseFactory listRestaurantUseCase;
    private final RestaurantBuilderFactory restaurantBuilderFactory;

    /**
     * -----------------------------
     * ------- GET METHODS
     * -----------------------------
     */
    @GetMapping(path = URLMapping.ROOT_API_WS_RESTAURANTS)
    public ResponseEntity<ListRestaurantResponse> list() {
        return ResponseEntity.ok(new ListRestaurantResponse(
                listRestaurantUseCase.getListRestaurantUseCase().execute().stream().map(
                        restaurantBuilderFactory.getRestaurantBuilder()::build).collect(Collectors.toList())));
    }


    /**
     * -----------------------------
     * ------- POST METHODS
     * -----------------------------
     */

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