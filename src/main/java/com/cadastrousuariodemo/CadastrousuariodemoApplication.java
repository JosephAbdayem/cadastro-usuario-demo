package com.cadastrousuariodemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

/**
 * Classe principal que inicia a aplicação.
 *
 * Aplica os princípios de Clean Code e SOLID.
 *
 * @version 1.0
 * @since 2023-05-08
 */
@SpringBootApplication
@EntityScan("com.cadastrousuariodemo.model")
public class CadastrousuariodemoApplication {

    /**
     * Método principal que inicia a aplicação.
     *
     * @param args argumentos de linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        SpringApplication.run(CadastrousuariodemoApplication.class, args);
    }

    /**
     * Cria um bean MethodValidationPostProcessor.
     *
     * @return o bean criado
     */
    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }
}
