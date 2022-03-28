package br.csantos.tp3melhorespraticas.datasource.h2.mappers;

import br.csantos.tp3melhorespraticas.datasource.h2.model.UniversitarioModel;
import br.csantos.tp3melhorespraticas.domain.student.Universitario;
import org.mapstruct.Mapper;

@Mapper
public interface UniversitarioMapper {

    UniversitarioModel map(Universitario universitario);

    Universitario map(UniversitarioModel universitario);
}
