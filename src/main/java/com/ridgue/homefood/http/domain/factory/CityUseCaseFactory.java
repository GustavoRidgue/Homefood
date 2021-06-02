package com.ridgue.homefood.http.domain.factory;

import com.ridgue.homefood.usecase.city.ListCityUseCase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
@AllArgsConstructor
public class CityUseCaseFactory {
    private final ListCityUseCase listCityUseCase;
}
