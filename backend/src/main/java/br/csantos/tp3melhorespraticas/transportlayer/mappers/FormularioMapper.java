package br.csantos.tp3melhorespraticas.transportlayer.mappers;

import br.csantos.tp3melhorespraticas.domain.FormularioMatricula;
import br.csantos.tp3melhorespraticas.transportlayer.input.FormularioMatriculaInput;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface FormularioMapper {

    @Mapping(target = "nascimento", dateFormat = "yyyy-MM-dd")
    FormularioMatricula map(FormularioMatriculaInput input);
}
