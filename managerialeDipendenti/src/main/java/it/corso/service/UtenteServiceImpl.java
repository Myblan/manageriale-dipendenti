package it.corso.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.codec.digest.DigestUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.DipartimentoDao;
import it.corso.dao.RuoloDao;
import it.corso.dao.UtenteDao;
import it.corso.dto.UtenteAddDto;
import it.corso.dto.UtenteAggiornaDto;
import it.corso.dto.UtenteDto;
import it.corso.model.Dipartimento;
import it.corso.model.Ruolo;
import it.corso.model.Utente;

@Service
public class UtenteServiceImpl implements UtenteService{

	@Autowired
	private UtenteDao utenteDao;
    
	@Autowired
	private DipartimentoDao dipartimentoDao;
	
	@Autowired
	private RuoloDao ruoloDao;
	
	private ModelMapper mapper = new ModelMapper();

	@Override
	public void updateUtente(UtenteAggiornaDto utente) {
		
		try {
			
			Utente utenteFromDb=utenteDao.findById(utente.getId()).get();
			if(utenteFromDb!=null) {
				utenteFromDb.setNome(utente.getNome());
				utenteFromDb.setCognome(utente.getCognome());
				utenteFromDb.setPassword(DigestUtils.sha256Hex(utente.getPassword()));
				utenteFromDb.setDataNascita(utente.getDataNascita());
				utenteFromDb.setDataAssunzione(utente.getDataAssunzione());
				utenteFromDb.setDipartimento(dipartimentoDao.findById(utente.getDipartimento()).get());
				utenteFromDb.setRuolo(ruoloDao.findById(utente.getRuolo()).get());
				utenteDao.save(utenteFromDb);
				}
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}

	@Override
	public UtenteDto getUtenteById(int id) {
		
		Optional<Utente> utente=utenteDao.findById(id);
		UtenteDto utenteDto= mapper.map(utente, UtenteDto.class);
		return utenteDto;
		
	}

	@Override
	public List<UtenteDto> getUtenteByNomeECognome(String nome, String cognome) {
		List<Utente> utenti=(List<Utente>) utenteDao.findByNomeAndCognome(nome, cognome);
		List<UtenteDto> utentiDto= new ArrayList<>();
		utenti.forEach(u-> utentiDto.add(mapper.map(u, UtenteDto.class)));
		return utentiDto;
	}

	@Override
	public List<UtenteDto> getUtenteByDipartimento(String dipartimento) {
		
		List<Utente> utenti=(List<Utente>) utenteDao.findByDipartimento(dipartimento);
		List<UtenteDto> utentiDto= new ArrayList<UtenteDto>();
		utenti.forEach(u-> utentiDto.add(mapper.map(u, UtenteDto.class)));
		return utentiDto;
	}

	@Override
	public List<UtenteDto> getUtenteByRuolo(String ruolo) {
		
		List<Utente> utenti=(List<Utente>) utenteDao.findByRuolo(ruolo);
		List<UtenteDto> utentiDto= new ArrayList<UtenteDto>();
		utenti.forEach(u-> utentiDto.add(mapper.map(u, UtenteDto.class)));
		return utentiDto;
	}


	@Override
	public void addUtente(UtenteAddDto utenteDto) {
		try {
			
			Optional<Dipartimento> dipartimentoOp = dipartimentoDao.findById(utenteDto.getDipartimento());
			Optional<Ruolo> ruoloOp = ruoloDao.findById(utenteDto.getRuolo());
			if(dipartimentoOp.isPresent() && ruoloOp.isPresent()) {
				Utente utente = new Utente();
				utente.setNome(utenteDto.getNome());
				utente.setCognome(utenteDto.getCognome());
				String sha256hex = DigestUtils.sha256Hex(utenteDto.getPassword());
				utente.setPassword(sha256hex);
				utente.setDataNascita(utenteDto.getDataNascita());
				utente.setDataAssunzione(utenteDto.getDataAssunzione());
				utente.setAdmin(utenteDto.getIsAdmin());
				utente.setStipendio(utenteDto.getStipendio());
				utente.setDipartimento(dipartimentoOp.get());
				utente.setRuolo(ruoloOp.get());
				utenteDao.save(utente);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void deleteUtenteById(int id) {
		Optional<Utente> utenteOptional=utenteDao.findById(id);
		if(utenteOptional.isPresent()) {
			utenteDao.delete(utenteOptional.get());
		}
		
	}
	
	@Override
	public List<UtenteDto> getUtenti() {
		
		List<Utente> utentiFromDb = (List<Utente>) utenteDao.findAll();
		
		List<UtenteDto> utenti = new ArrayList<>();
		
		utentiFromDb.forEach(u -> utenti.add(mapper.map(u, UtenteDto.class)));
		
		return utenti;
	}
	
}
