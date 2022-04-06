package br.csantos.tp3melhorespraticas.datasource.h2;

import br.csantos.tp3melhorespraticas.domain.student.Primario;
import br.csantos.tp3melhorespraticas.domain.student.Universitario;
import br.csantos.tp3melhorespraticas.utils.Factory;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

@Import(InstituicaoDataSource.class)
@DataJpaTest
class InstituicaoDataSourceTest {

    @Autowired
    InstituicaoDataSource instituicaoDataSource;

    @BeforeEach
    void init() {
        var alunoPrimario = Factory.getAlunoPrimario();
        var alunoUniversitario = Factory.getAlunoUniversitario();

        instituicaoDataSource.salvar(alunoPrimario);
        instituicaoDataSource.salvar(alunoUniversitario);
    }

    @Test
    void deveSalvarAlunoPrimario() {
        var alunoPrimario = Factory.getAlunoPrimario();

        var response = instituicaoDataSource.salvar(alunoPrimario);

        Assertions.assertNotNull(response);
        Assertions.assertInstanceOf(Primario.class, response);
    }

    @Test
    void deveSalvarAlunoUniversitario() {
        var alunoUniversitario = Factory.getAlunoUniversitario();

        var response = instituicaoDataSource.salvar(alunoUniversitario);
        Assertions.assertNotNull(response);
        Assertions.assertInstanceOf(Universitario.class, response);
    }

    @Test
    void deveRetornarAlunoPrimario() {
        var response = instituicaoDataSource.consultarPrimarios();
        Assertions.assertNotNull(response);
    }

    @Test
    void deveRetornarAlunoUniversitario() {
        var response = instituicaoDataSource.consultarUniversitarios();
        Assertions.assertNotNull(response);
        Assertions.assertEquals(1, response.size());
    }
}