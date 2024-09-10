package it.corso.service;

import java.util.List;

import it.corso.dto.UtenteAddDto;

import it.corso.dto.UtenteAggiornaDto;
import it.corso.dto.UtenteDto;

public interface UtenteService {

	UtenteDto getUtenteById(int id);
	List<UtenteDto> getUtenteByNomeECognome(String nome, String cognome);
	List<UtenteDto> getUtenteByDipartimento(String dipartimento);
	List<UtenteDto> getUtenteByRuolo(String ruolo);
	List<UtenteDto> getUtenti();
	void addUtente(UtenteAddDto utente);
	void updateUtente(UtenteAggiornaDto utente);
	void deleteUtenteById(int id);
}
