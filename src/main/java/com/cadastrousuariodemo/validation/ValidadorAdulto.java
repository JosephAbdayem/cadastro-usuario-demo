package com.cadastrousuariodemo.validation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.Period;

/**
 * Implementa a validação da idade mínima em anos para um usuário.
 */
public class ValidadorAdulto implements ConstraintValidator<Adulto, LocalDate> {

    private static final int IDADE_MINIMA = 18;

    /**
     * Inicializa o validador.
     *
     * @param constraintAnnotation a anotação de restrição
     */
    @Override
    public void initialize(Adulto constraintAnnotation) {
        // Nenhuma inicialização necessária
    }

    /**
     * Verifica se a data de nascimento informada é válida e atende ao requisito de idade mínima.
     *
     * @param dataNascimento a data de nascimento a ser validada
     * @param context        o contexto do validador de restrição
     * @return true se a data de nascimento é válida e atende ao requisito de idade mínima, false caso contrário
     */
    @Override
    public boolean isValid(LocalDate dataNascimento, ConstraintValidatorContext context) {
        if (dataNascimento == null) {
            return true;
        }

        int idade = Period.between(dataNascimento, LocalDate.now()).getYears();
        return idade >= IDADE_MINIMA;
    }
}
