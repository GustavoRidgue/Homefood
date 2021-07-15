package com.ridgue.homefood.http.domain.response.product;

import com.ridgue.homefood.domain.ProductTO;
import com.ridgue.homefood.domain.RestaurantTO;
import com.ridgue.homefood.http.domain.response.DefaultResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class ListProductResponse extends DefaultResponse {
    private List<ProductTO> productTOS;
}