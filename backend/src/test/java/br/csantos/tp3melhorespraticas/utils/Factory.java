package br.csantos.tp3melhorespraticas.utils;

import br.csantos.tp3melhorespraticas.domain.FormularioMatricula;
import br.csantos.tp3melhorespraticas.domain.student.Primario;
import br.csantos.tp3melhorespraticas.domain.student.Universitario;
import br.csantos.tp3melhorespraticas.domain.student.formularios.FormularioPrimario;
import br.csantos.tp3melhorespraticas.domain.student.formularios.FormularioUniversitario;
import br.csantos.tp3melhorespraticas.domain.valueObjects.Matricula;
import br.csantos.tp3melhorespraticas.transportlayer.input.FormularioMatriculaInput;
import br.csantos.tp3melhorespraticas.transportlayer.output.MatriculasResponse;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Factory {

    public static Primario getAlunoPrimario() {
        return new Primario(getFormularioPrimario());
    }

    public static Universitario getAlunoUniversitario() {
        return new Universitario(getFormularioUniversitario());
    }

    public static FormularioMatricula getFormularioGenericoPrimario() {
        return new FormularioMatricula("dummy", Calendar.getInstance().getTime(), "dummy");
    }

    public static FormularioMatricula getFormularioGenericoUniversitario() {
        var nascimentoCalendar = new GregorianCalendar(1994, 10, 10);
        return new FormularioMatricula("dummy", nascimentoCalendar.getTime(), null);
    }

    public static FormularioPrimario getFormularioPrimario() {
        return new FormularioPrimario("dummy", "dummy", Calendar.getInstance().getTime());
    }

    public static FormularioUniversitario getFormularioUniversitario() {
        var nascimentoCalendar = new GregorianCalendar(1994, 10, 10);
        var date = nascimentoCalendar.getTime();

        FormularioMatricula formulario = new FormularioMatricula("dummy",  date, null);
        return new FormularioUniversitario(formulario);
    }

    public static FormularioMatriculaInput getFormularioMatriculaPrimarioInput() {
        return new FormularioMatriculaInput("dummy", "2022-01-01", "dummy");
    }

    public static FormularioMatriculaInput getFormularioMatriculaUniversitarioInput() {
        return new FormularioMatriculaInput("dummy", "2022-01-01", null);
    }

    public static List<MatriculasResponse> getMatriculas() {
        return List.of(
                new MatriculasResponse(1L, Matricula.PRIMARIO.name(), "dummy", new Date(), "dummy"),
                new MatriculasResponse(2L, Matricula.UNIVERSITARIO.name(), "dummy", new Date(), "dummy")
        );
    }
}
