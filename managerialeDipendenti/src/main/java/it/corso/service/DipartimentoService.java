package it.corso.service;

import java.util.List;

import it.corso.dto.DipartimentoAddDto;
import it.corso.dto.DipartimentoDto;

public interface DipartimentoService {

	List<DipartimentoDto> getDipartimenti();
	void addDipartimento(DipartimentoAddDto dipartimentoDto);
	boolean deleteDipartimentoById(int id);
	boolean existsByNome(String nome);
}
