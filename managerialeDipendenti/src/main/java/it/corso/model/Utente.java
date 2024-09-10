package it.corso.model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "utenti")
public class Utente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Pattern(regexp = "[a-zA-Z\\èàùìò]{1,50}", message = "Nome con caratteri non ammessi")
	@Column(name = "nome")
	private String nome;
		
	@Pattern(regexp = "[a-zA-Z\\èàùìò]{1,50}", message = "Cognome con caratteri non ammessi")
	@Column(name = "cognome")
	private String cognome;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "data_nascita")
	private LocalDate dataNascita;
	
	@Column(name = "data_assunzione")
	private LocalDate dataAssunzione;
	
	@Column(name = "stipendio")
	private double stipendio;
	
	@Column(name = "is_admin")
	private boolean isAdmin;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="id_dipartimento", referencedColumnName = "id")
	private Dipartimento dipartimento;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="id_ruolo", referencedColumnName = "id")
	private Ruolo ruolo;

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

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Dipartimento getDipartimento() {
		return dipartimento;
	}

	public void setDipartimento(Dipartimento dipartimento) {
		this.dipartimento = dipartimento;
	}

	public Ruolo getRuolo() {
		return ruolo;
	}

	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}
	
	
}
