package it.corso.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.RuoloDao;
import it.corso.dto.UtenteRuoloDto;
import it.corso.model.Ruolo;

@Service
public class RuoloServiceImpl implements RuoloService{

	@Autowired
	private RuoloDao ruoloDao;
	
	private ModelMapper mapper= new ModelMapper();
	

	@Override
	public void addRuolo(UtenteRuoloDto ruolo) {
		try {
			Ruolo ruoloDb= new Ruolo();
			ruoloDb= mapper.map(ruolo, Ruolo.class);
			ruoloDao.save(ruoloDb);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean deleteRuolo(int id) {
		Optional<Ruolo> ruoloDb=ruoloDao.findById(id);
		if(ruoloDb.isPresent()) {
			ruoloDao.delete(ruoloDb.get());
			return true;
		}
		return false;

	}

	@Override
	public List<UtenteRuoloDto> getRuoli() {
		List<Ruolo> ruoliDb=(List<Ruolo>) ruoloDao.findAll();
		List<UtenteRuoloDto> ruoli=new ArrayList<>();
		ruoliDb.forEach(r-> ruoli.add(mapper.map(r, UtenteRuoloDto.class)));
		return ruoli;
	}
}
