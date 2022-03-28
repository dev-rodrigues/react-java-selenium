package br.csantos.tp3melhorespraticas.interactor;

import br.csantos.tp3melhorespraticas.domain.student.Primario;
import br.csantos.tp3melhorespraticas.domain.student.Universitario;
import br.csantos.tp3melhorespraticas.port.InstituicaoPort;
import br.csantos.tp3melhorespraticas.utils.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {EfetuarMatricula.class})
@ExtendWith(SpringExtension.class)
class EfetuarMatriculaTest {

    @MockBean
    InstituicaoPort instituicaoPort;

    @SpyBean
    EfetuarMatricula efetuarMatricula;

    @Test
    void deveMatricularAlunoPrimario() {
        var formulario = Factory.getFormularioGenericoPrimario();
        var primario = Factory.getAlunoPrimario();

        Mockito.when(instituicaoPort.salvar(Mockito.any())).thenReturn(primario);

        var response = efetuarMatricula.executar(formulario);

        Assertions.assertNotNull(response);
        Assertions.assertInstanceOf(Primario.class, response);
    }

    @Test
    void deveMatricularAlunoUniversitario() {
        var formulario = Factory.getFormularioGenericoUniversitario();
        var universitario = Factory.getAlunoUniversitario();

        Mockito.when(instituicaoPort.salvar(Mockito.any())).thenReturn(universitario);

        var response = efetuarMatricula.executar(formulario);

        Assertions.assertNotNull(response);
        Assertions.assertInstanceOf(Universitario.class, response);
    }
}