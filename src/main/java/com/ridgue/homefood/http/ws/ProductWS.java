package com.ridgue.homefood.http.ws;

import com.ridgue.homefood.database.entity.ProductEntity;
import com.ridgue.homefood.database.entity.RestaurantEntity;
import com.ridgue.homefood.exceptions.InvalidFieldException;
import com.ridgue.homefood.exceptions.ResourceNotFoundException;
import com.ridgue.homefood.http.domain.factory.product.ProductBuilderFactory;
import com.ridgue.homefood.http.domain.factory.restaurant.RestaurantBuilderFactory;
import com.ridgue.homefood.http.domain.factory.restaurant.RestaurantUseCaseFactory;
import com.ridgue.homefood.http.domain.request.RestaurantRequest;
import com.ridgue.homefood.http.domain.response.DefaultResponse;
import com.ridgue.homefood.http.domain.response.order.ListOrderResponse;
import com.ridgue.homefood.http.domain.response.product.ListProductResponse;
import com.ridgue.homefood.http.domain.response.product.ProductResponse;
import com.ridgue.homefood.http.domain.response.restaurant.ListRestaurantResponse;
import com.ridgue.homefood.http.domain.response.restaurant.RestaurantResponse;
import com.ridgue.homefood.http.ws.base.URLMapping;
import com.ridgue.homefood.usecase.product.FindProductByIdUseCase;
import com.ridgue.homefood.usecase.product.ListProductUseCase;
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
public class ProductWS {
    private final ListProductUseCase listProductUseCase;
    private final FindProductByIdUseCase findProductByIdUseCase;
    private final ProductBuilderFactory productBuilderFactory;

    /**
     * -----------------------------
     * ------- GET METHODS
     * -----------------------------
     */
    @GetMapping(path = ROOT_API_WS_PRODUCT)
    public ResponseEntity<ListProductResponse> list() {
        return ResponseEntity.ok(new ListProductResponse(listProductUseCase.execute().stream().map(productBuilderFactory.getProductBuilder()::build).collect(Collectors.toList())));
    }

    @GetMapping(path = ROOT_API_WS_PRODUCT_BY_ID)
    public ResponseEntity<ProductResponse> listById(@PathVariable(name = "id") Long id) {
        try {
            return ResponseEntity.ok(new ProductResponse(productBuilderFactory.getProductBuilder().build(findProductByIdUseCase.execute(id))));
        } catch (NullPointerException e) {
            return ResponseEntity.notFound().build();
        }
    }
}