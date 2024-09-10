package it.corso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.corso.model.Utente;

public interface UtenteDao extends CrudRepository<Utente, Integer>{
     
	
	
	@Query(value = "SELECT * FROM utenti WHERE id_dipartimento = (SELECT id FROM dipartimenti WHERE nome LIKE CONCAT('%', :dipartimento, '%'))", nativeQuery = true)
	List<Utente> findByDipartimento(String dipartimento);
	
	@Query(value = "SELECT * FROM utenti WHERE id_ruolo = (SELECT id FROM ruoli WHERE nome LIKE CONCAT('%', :ruolo, '%'))", nativeQuery = true)
	List<Utente> findByRuolo(String ruolo);
	
	@Query(value = "SELECT * FROM utenti WHERE nome LIKE CONCAT('%', :nome, '%') AND cognome LIKE CONCAT('%', :cognome, '%')", nativeQuery = true)
	List<Utente> findByNomeAndCognome(String nome, String cognome);
}
