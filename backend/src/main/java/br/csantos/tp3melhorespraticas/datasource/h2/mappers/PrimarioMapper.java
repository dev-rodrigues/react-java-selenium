package br.csantos.tp3melhorespraticas.datasource.h2.mappers;

import br.csantos.tp3melhorespraticas.datasource.h2.model.PrimarioModel;
import br.csantos.tp3melhorespraticas.domain.student.Primario;
import org.mapstruct.Mapper;

@Mapper
public interface PrimarioMapper {

    PrimarioModel map(Primario primario);

    Primario map(PrimarioModel primario);
}
