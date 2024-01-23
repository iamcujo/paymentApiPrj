package org.example.paymentapiprj.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"org.example.paymentapiprj.controller", "org.example.paymentapiprj.Repository"})
public class TestConfig {
}
