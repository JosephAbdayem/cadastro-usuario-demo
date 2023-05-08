package com.cadastrousuariodemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;


@SpringBootApplication
@EntityScan("com.cadastrousuariodemo.model")
public class CadastrousuariodemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(CadastrousuariodemoApplication.class, args);
    }

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }
}
