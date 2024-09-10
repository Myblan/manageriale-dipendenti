package it.corso.service;

import java.util.List;

import it.corso.dto.UtenteRuoloDto;

public interface RuoloService {

	void addRuolo(UtenteRuoloDto ruolo);
	boolean deleteRuolo(int id);
	List<UtenteRuoloDto> getRuoli();
}
