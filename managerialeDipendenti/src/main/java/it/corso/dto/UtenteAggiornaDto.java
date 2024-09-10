package it.corso.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

public class UtenteAggiornaDto {

private int id;
	
    @Pattern(regexp = "[a-zA-Z\\èàùìò]{1,50}", message = "Nome con caratteri non ammessi")
	private String nome;
	
    @Pattern(regexp = "[a-zA-Z\\èàùìò]{1,50}", message = "Cognome con caratteri non ammessi")
	private String cognome;
	
	private String password;
	
	@Past(message = "la data deve essere nel passato")
	private LocalDate dataNascita;
	
	@Past(message = "la data deve essere nel passato")
	private LocalDate dataAssunzione;
	
	private int dipartimento;
	
	private int ruolo;

	public int getDipartimento() {
		return dipartimento;
	}

	public void setDipartimento(int dipartimento) {
		this.dipartimento = dipartimento;
	}

	public int getRuolo() {
		return ruolo;
	}

	public void setRuolo(int ruolo) {
		this.ruolo = ruolo;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
