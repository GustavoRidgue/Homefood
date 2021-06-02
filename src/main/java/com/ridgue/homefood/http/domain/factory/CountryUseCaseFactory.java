package com.ridgue.homefood.http.domain.factory;

import com.ridgue.homefood.usecase.country.CreateCountryUseCase;
import com.ridgue.homefood.usecase.country.FindCountryByIdUseCase;
import com.ridgue.homefood.usecase.country.ListCountryUseCase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
@AllArgsConstructor
public class CountryUseCaseFactory {
    private final ListCountryUseCase listCountryUseCase;
    private final FindCountryByIdUseCase findCountryByIdUseCase;
    private final CreateCountryUseCase createCountryUseCase;
}
