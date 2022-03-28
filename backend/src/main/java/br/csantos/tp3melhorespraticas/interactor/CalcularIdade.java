package br.csantos.tp3melhorespraticas.interactor;

import org.springframework.lang.NonNull;

import java.util.Calendar;
import java.util.Date;

public class CalcularIdade {

    private static final int ANO_ATUAL = Calendar.getInstance().get(Calendar.YEAR);
    private static final int RESET_ANO = 1900;

    public static int executar(@NonNull Date nascimento) {
        return ANO_ATUAL - (nascimento.getYear() + RESET_ANO);
    }
}
