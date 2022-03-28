package br.csantos.tp3melhorespraticas.transportlayer;

import br.csantos.tp3melhorespraticas.interactor.ConsultarMatriculas;
import br.csantos.tp3melhorespraticas.interactor.EfetuarMatricula;
import br.csantos.tp3melhorespraticas.utils.Factory;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class SecretariaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    SecretariaController controller;

    @Mock
    EfetuarMatricula efetuarMatricula;

    @Mock
    ConsultarMatriculas consultarMatriculas;

    static final String PATH = "/secretaria/";

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

    }

    @Test
    void deveMatricularAlunoPrimario() throws Exception {

        var formulario = Factory.getFormularioMatriculaPrimarioInput();
        var jsonFormulario = new Gson().toJson(formulario);
        var primario = Factory.getAlunoPrimario();

        Mockito.when(efetuarMatricula.executar(Mockito.any())).thenReturn(primario);

        mockMvc.perform(MockMvcRequestBuilders.post(PATH, 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonFormulario)
        ).andExpect(status().isOk());
    }

    @Test
    void deveMatricularAlunoUniversitario() throws Exception {
        var formulario = Factory.getFormularioMatriculaUniversitarioInput();
        var jsonFormulario = new Gson().toJson(formulario);
        var universitario = Factory.getAlunoUniversitario();

        Mockito.when(efetuarMatricula.executar(Mockito.any())).thenReturn(universitario);

        mockMvc.perform(MockMvcRequestBuilders.post(PATH, 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonFormulario)
        ).andExpect(status().isOk());
    }

    @Test
    void deveConsultarMatriculas() throws Exception {
        var matriculas = Factory.getMatriculas();

        Mockito.when(consultarMatriculas.executar()).thenReturn(matriculas);

        mockMvc.perform(MockMvcRequestBuilders.get(PATH, 1)
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

}