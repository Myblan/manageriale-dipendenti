package it.corso.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

public class UtenteAddDto {

	@Pattern(regexp = "[a-zA-Z\\èàùìò]{1,50}", message = "Nome con caratteri non ammessi")
	private String nome;
	
	@Pattern(regexp = "[a-zA-Z\\èàùìò]{1,50}", message = "Cognome con caratteri non ammessi")
	private String cognome;
	
	private String password;
	
	@Past(message = "la data deve essere nel passato")
	private LocalDate dataNascita;
	
	@Past(message = "la data deve essere nel passato")
	private LocalDate dataAssunzione;
	
	@Min(value = 500, message = "lo stipendio deve essere superiore a 500")
	private double stipendio;
	
	private boolean isAdmin;
	
	@Min(value = 1, message = "il dipartimento deve essere minimo 1")
	private int dipartimento;
	
	@Min(value = 1, message = "il ruolo deve essere minimo 1")
	private int ruolo;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

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
	
}
