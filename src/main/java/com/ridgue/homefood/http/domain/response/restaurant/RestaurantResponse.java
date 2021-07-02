package com.ridgue.homefood.http.domain.response.restaurant;

import com.ridgue.homefood.domain.ClientTO;
import com.ridgue.homefood.domain.RestaurantTO;
import com.ridgue.homefood.http.domain.response.DefaultResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

//import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class RestaurantResponse extends DefaultResponse {
    private RestaurantTO restaurantTO;
}