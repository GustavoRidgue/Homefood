package com.ridgue.homefood.http.ws;

import com.ridgue.homefood.database.entity.OrderEntity;
import com.ridgue.homefood.database.entity.ProductEntity;
import com.ridgue.homefood.database.entity.RestaurantEntity;
import com.ridgue.homefood.exceptions.InvalidFieldException;
import com.ridgue.homefood.exceptions.ResourceNotFoundException;
import com.ridgue.homefood.http.domain.factory.order.OrderBuilderFactory;
import com.ridgue.homefood.http.domain.factory.restaurant.RestaurantBuilderFactory;
import com.ridgue.homefood.http.domain.factory.restaurant.RestaurantUseCaseFactory;
import com.ridgue.homefood.http.domain.request.RestaurantRequest;
import com.ridgue.homefood.http.domain.response.DefaultResponse;
import com.ridgue.homefood.http.domain.response.client.ListClientResponse;
import com.ridgue.homefood.http.domain.response.order.ListOrderResponse;
import com.ridgue.homefood.http.domain.response.restaurant.ListRestaurantResponse;
import com.ridgue.homefood.http.domain.response.restaurant.RestaurantResponse;
import com.ridgue.homefood.http.ws.base.URLMapping;
import com.ridgue.homefood.usecase.order.ListOrderUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.ridgue.homefood.http.ws.base.URLMapping.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = URLMapping.ROOT_API_PATH)
public class OrderWS {
    private final ListOrderUseCase listOrderUseCase;
    private final OrderBuilderFactory orderBuilderFactory;

    /**
     * -----------------------------
     * ------- GET METHODS
     * -----------------------------
     */
    @GetMapping(path = ROOT_API_WS_ORDER)
    public ResponseEntity<ListOrderResponse> list() {
        return ResponseEntity.ok(new ListOrderResponse(listOrderUseCase.execute().stream().map(orderBuilderFactory.getOrderBuilder()::build).collect(Collectors.toList())));
    }
}