package it.corso.dao;

import org.springframework.data.repository.CrudRepository;

import it.corso.model.Dipartimento;

public interface DipartimentoDao extends CrudRepository<Dipartimento, Integer>{

	boolean existsByNome(String nome);
}
