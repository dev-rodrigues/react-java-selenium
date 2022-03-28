package br.csantos.tp3melhorespraticas.datasource.h2.data;

import br.csantos.tp3melhorespraticas.datasource.h2.model.PrimarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrimarioData extends JpaRepository<PrimarioModel, Long> {
}
