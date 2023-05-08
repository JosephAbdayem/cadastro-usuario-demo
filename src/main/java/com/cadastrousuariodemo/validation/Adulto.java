package com.cadastrousuariodemo.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Anotação personalizada para validar se um usuário é adulto (idade maior ou igual a 18 anos).
 */
@Documented
@Constraint(validatedBy = ValidadorAdulto.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Adulto {

    /**
     * Mensagem padrão exibida quando a validação falha.
     *
     * @return a mensagem de erro
     */
    String message() default "Usuário deve ser maior de 18 anos";

    /**
     * Grupos de validação relacionados.
     *
     * @return um array de classes de grupo
     */
    Class<?>[] groups() default {};

    /**
     * Payload opcional para fornecer metadados adicionais.
     *
     * @return um array de classes de payload
     */
    Class<? extends Payload>[] payload() default {};
}
