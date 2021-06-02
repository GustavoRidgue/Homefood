package com.ridgue.homefood.http.ws;

import com.ridgue.homefood.http.domain.factory.CityBuilderFactory;
import com.ridgue.homefood.http.domain.factory.CityUseCaseFactory;
import com.ridgue.homefood.http.domain.response.city.ListCityResponse;
import com.ridgue.homefood.http.ws.base.URLMapping;
import com.ridgue.homefood.usecase.city.ListCityUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = URLMapping.ROOT_API_PATH)
public class CityWS {
    private final CityBuilderFactory cityBuilderFactory;
    private final CityUseCaseFactory cityUseCaseFactory;
    private final ListCityUseCase listCityUseCase;

    /**
     * -----------------------------
     * ------- GET METHODS
     * -----------------------------
     */
    @GetMapping(path = URLMapping.ROOT_API_WS_CITIES)
    public ResponseEntity<ListCityResponse> list() {
        return ResponseEntity.ok(new ListCityResponse(listCityUseCase.execute().stream().map(cityBuilderFactory.getCityBuilder()::build).collect(Collectors.toList())));
    }
}
