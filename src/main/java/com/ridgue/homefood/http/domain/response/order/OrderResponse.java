package com.ridgue.homefood.http.domain.response.order;

import com.ridgue.homefood.domain.OrderTO;
import com.ridgue.homefood.domain.RestaurantTO;
import com.ridgue.homefood.http.domain.response.DefaultResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class OrderResponse extends DefaultResponse {
    private OrderTO orderTO;
}