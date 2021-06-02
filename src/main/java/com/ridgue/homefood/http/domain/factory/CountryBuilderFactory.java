package com.ridgue.homefood.http.domain.factory;

import com.ridgue.homefood.http.domain.builder.CountryBuilder;
import com.ridgue.homefood.http.domain.builder.StateBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
@AllArgsConstructor
public class CountryBuilderFactory {
    private final CountryBuilder countryBuilder;
}
