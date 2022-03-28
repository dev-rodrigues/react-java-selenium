package br.csantos.tp3melhorespraticas.interactor;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.GregorianCalendar;

import static br.csantos.tp3melhorespraticas.interactor.CalcularIdade.executar;

class CalcularIdadeTest {

    @Test
    void deveCalcularIdadeQuandoDataValida() {
        var nascimentoCalendar = new GregorianCalendar(1994, 10, 10);
        var date = nascimentoCalendar.getTime();

        var idade = executar(date);

        Assertions.assertNotNull(idade);
        Assertions.assertEquals(28, idade);
    }

    @Test
    void deveLancarNullPointerQuandoDataNula() {

        Assertions.assertThrows(NullPointerException.class, () -> {
            executar(null);
        });
    }

}