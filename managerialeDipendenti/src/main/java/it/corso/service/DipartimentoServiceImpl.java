package it.corso.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.DipartimentoDao;
import it.corso.dto.DipartimentoAddDto;
import it.corso.dto.DipartimentoDto;
import it.corso.model.Dipartimento;

@Service
public class DipartimentoServiceImpl implements DipartimentoService {

	@Autowired
	private DipartimentoDao dipartimentoDao;
	
	private ModelMapper mapper = new ModelMapper();
	
	@Override
	public List<DipartimentoDto> getDipartimenti() {
		try {
			List<Dipartimento> dipartimentiFromDb = (List<Dipartimento>) dipartimentoDao.findAll();
			List<DipartimentoDto> dipartimenti = new ArrayList<>();
			dipartimentiFromDb.forEach(u -> dipartimenti.add(mapper.map(u, DipartimentoDto.class)));
			return dipartimenti;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void addDipartimento(DipartimentoAddDto dipartimentoDto) {
		try {
			Dipartimento dipartimento = new Dipartimento();
			dipartimento = mapper.map(dipartimentoDto, Dipartimento.class);
			dipartimentoDao.save(dipartimento);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean deleteDipartimentoById(int id) {
		try {
			Optional<Dipartimento> dipartimentoOp = dipartimentoDao.findById(id);
			if(dipartimentoOp.isPresent()) {
				dipartimentoDao.delete(dipartimentoOp.get());
				return true;
			}
			else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public boolean existsByNome(String nome) {
		return dipartimentoDao.existsByNome(nome);
	}

}
