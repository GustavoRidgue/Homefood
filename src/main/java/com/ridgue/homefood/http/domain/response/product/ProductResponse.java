package com.ridgue.homefood.http.domain.response.product;

import com.ridgue.homefood.domain.ProductTO;
import com.ridgue.homefood.domain.RestaurantTO;
import com.ridgue.homefood.http.domain.response.DefaultResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class ProductResponse extends DefaultResponse {
    private ProductTO productTO;
}