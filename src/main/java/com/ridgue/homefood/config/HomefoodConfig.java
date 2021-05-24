package com.ridgue.homefood.config;

import com.ridgue.homefood.usecase.client.ActivateClientUseCase;
import com.ridgue.homefood.usecase.notify.EmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HomefoodConfig {
    @Bean
    public EmailService emailService() {
        return new EmailService(true, "smtp.homefood.com");
    }

    @Bean
    public ActivateClientUseCase activateClientService() {
        //return bean gerenciaded by spring
        return new ActivateClientUseCase(emailService());
    }
}
