package org.example.paymentapiprj.config;

import org.example.paymentapiprj.PaymentApiPrjApplication;
import org.example.paymentapiprj.Repository.BalanceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"org.example.paymentapiprj.controller", "org.example.paymentapiprj.service", "org.example.paymentapiprj.Repository"})
public class AppConfig {

    @Bean
    public BalanceRepository balanceRepository() {
        return (BalanceRepository) new PaymentApiPrjApplication();
    }

}
