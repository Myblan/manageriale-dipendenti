package it.corso.dto;

import java.util.ArrayList;
import java.util.List;

public class RuoloDto {

	
private int id;
	
	private String nome;
	
	private String descrizione;
	
	private List<UtenteDto> utenti = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public List<UtenteDto> getUtenti() {
		return utenti;
	}

	public void setUtenti(List<UtenteDto> utenti) {
		this.utenti = utenti;
	}

}
