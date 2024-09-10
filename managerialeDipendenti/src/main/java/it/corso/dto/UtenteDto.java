package it.corso.dto;

import java.time.LocalDate;



public class UtenteDto {

	private int id;
	
	private String nome;
		
	private String cognome;
	
	private LocalDate dataNascita;
	
	private LocalDate dataAssunzione;
	
	private double stipendio;
	
	private UtenteDipartimentoDto dipartimento;
	
	private UtenteRuoloDto ruolo;

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

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	public LocalDate getDataAssunzione() {
		return dataAssunzione;
	}

	public void setDataAssunzione(LocalDate dataAssunzione) {
		this.dataAssunzione = dataAssunzione;
	}

	public double getStipendio() {
		return stipendio;
	}

	public void setStipendio(double stipendio) {
		this.stipendio = stipendio;
	}

	public UtenteDipartimentoDto getDipartimento() {
		return dipartimento;
	}

	public void setDipartimento(UtenteDipartimentoDto dipartimento) {
		this.dipartimento = dipartimento;
	}

	public UtenteRuoloDto getRuolo() {
		return ruolo;
	}

	public void setRuolo(UtenteRuoloDto ruolo) {
		this.ruolo = ruolo;
	}


	
	
}
