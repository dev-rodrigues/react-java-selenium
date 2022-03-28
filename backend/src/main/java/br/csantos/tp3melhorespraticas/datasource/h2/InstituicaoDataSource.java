package br.csantos.tp3melhorespraticas.datasource.h2;

import br.csantos.tp3melhorespraticas.datasource.h2.data.PrimarioData;
import br.csantos.tp3melhorespraticas.datasource.h2.data.UniversitarioData;
import br.csantos.tp3melhorespraticas.datasource.h2.mappers.PrimarioMapper;
import br.csantos.tp3melhorespraticas.datasource.h2.mappers.UniversitarioMapper;
import br.csantos.tp3melhorespraticas.domain.student.Aluno;
import br.csantos.tp3melhorespraticas.domain.student.Primario;
import br.csantos.tp3melhorespraticas.domain.student.Universitario;
import br.csantos.tp3melhorespraticas.port.InstituicaoPort;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class InstituicaoDataSource implements InstituicaoPort {

    private final PrimarioData primarioData;
    private final UniversitarioData universitarioData;

    private final UniversitarioMapper universitarioMapper;
    private final PrimarioMapper primarioMapper;

    public InstituicaoDataSource(PrimarioData primarioData, UniversitarioData universitarioData) {
        this.primarioData = primarioData;
        this.universitarioData = universitarioData;

        this.universitarioMapper = Mappers.getMapper(UniversitarioMapper.class);
        this.primarioMapper = Mappers.getMapper(PrimarioMapper.class);
    }

    @Override
    public Aluno salvar(Aluno aluno) {

        if (aluno instanceof Primario) {
            return alunoPrimario(aluno);

        } else if (aluno instanceof Universitario){
            return alunoUniversitario(aluno);
        }

        throw new RuntimeException("Aluno não é primario nem universitario");
    }

    @Override
    public List<Primario> consultarPrimarios() {
        return primarioData
                .findAll()
                .stream()
                .map(primarioMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public List<Universitario> consultarUniversitarios() {
        return universitarioData.findAll().stream().map(universitarioMapper::map).collect(Collectors.toList());
    }

    private Primario alunoPrimario(Aluno aluno) {
        var primario = (Primario) aluno;
        var primarioModel = primarioMapper.map(primario);
        primarioModel = primarioData.save(primarioModel);

        return primarioMapper.map(primarioModel);
    }

    private Universitario alunoUniversitario(Aluno aluno) {
        var universitario = (Universitario) aluno;
        var universitarioModel = universitarioMapper.map(universitario);
        universitarioModel = universitarioData.save(universitarioModel);

        return universitarioMapper.map(universitarioModel);
    }
}
