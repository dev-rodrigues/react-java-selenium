package br.csantos.tp3melhorespraticas.datasource.h2.data;

import br.csantos.tp3melhorespraticas.datasource.h2.model.UniversitarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversitarioData extends JpaRepository<UniversitarioModel, Long> {
}
