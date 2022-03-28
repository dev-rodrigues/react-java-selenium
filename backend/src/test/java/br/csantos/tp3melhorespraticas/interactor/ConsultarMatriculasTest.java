package br.csantos.tp3melhorespraticas.interactor;

import br.csantos.tp3melhorespraticas.port.InstituicaoPort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static br.csantos.tp3melhorespraticas.utils.Factory.getAlunoPrimario;
import static br.csantos.tp3melhorespraticas.utils.Factory.getAlunoUniversitario;

@ContextConfiguration(classes = {ConsultarMatriculas.class})
@ExtendWith(SpringExtension.class)
class ConsultarMatriculasTest {

    @MockBean
    InstituicaoPort instituicaoPort;

    @SpyBean
    ConsultarMatriculas consultarMatriculas;

    @Test
    void deveRetornarArrayDeMatriculasResponse() {
        Mockito.when(instituicaoPort.consultarPrimarios()).thenReturn(List.of(getAlunoPrimario()));
        Mockito.when(instituicaoPort.consultarUniversitarios()).thenReturn(List.of(getAlunoUniversitario()));
        var response = consultarMatriculas.executar();

        Assertions.assertNotNull(response);
        Assertions.assertEquals(2, response.size());
    }

}