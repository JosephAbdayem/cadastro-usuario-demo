package com.cadastrousuariodemo.validators;

import com.cadastrousuariodemo.validation.ValidadorAdulto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class ValidadorAdultoTest {

    private ValidadorAdulto validadorAdulto;
    private ConstraintValidatorContext constraintValidatorContext;

    @BeforeEach
    public void setUp() {
        validadorAdulto = new ValidadorAdulto();
        constraintValidatorContext = mock(ConstraintValidatorContext.class);
    }

    @Test
    public void testIsValid_MaiorDeIdade() {
        LocalDate dataNascimento = LocalDate.now().minusYears(18).minusDays(1);
        boolean resultado = validadorAdulto.isValid(dataNascimento, constraintValidatorContext);
        assertTrue(resultado, "A data de nascimento informada deve ser válida para um adulto.");
    }

    @Test
    public void testIsValid_MenorDeIdade() {
        LocalDate dataNascimento = LocalDate.now().minusYears(18).plusDays(1);
        boolean resultado = validadorAdulto.isValid(dataNascimento, constraintValidatorContext);
        assertFalse(resultado, "A data de nascimento informada não deve ser válida para um adulto.");
    }

    @Test
    public void testIsValid_Null() {
        boolean resultado = validadorAdulto.isValid(null, constraintValidatorContext);
        assertTrue(resultado, "A data de nascimento nula deve ser considerada válida.");
    }
}
