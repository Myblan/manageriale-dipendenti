package it.corso.dto;

import jakarta.validation.constraints.Pattern;

public class DipartimentoAddDto {
	
    @Pattern(regexp = "[a-zA-Z\\èàùìò0-9\\s-]{1,50}", message = "Nome con caratteri non ammessi")
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
