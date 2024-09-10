package it.corso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.corso.dto.DipartimentoAddDto;
import it.corso.dto.DipartimentoDto;
import it.corso.service.DipartimentoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/dipartimento")
@CrossOrigin
public class DipartimentoController {

	@Autowired
	private DipartimentoService dipartimentoService;
	
	@GetMapping("/get/all")
	public ResponseEntity<List<DipartimentoDto>> getDipartimenti() {
		try {
			List<DipartimentoDto> dipartimenti = dipartimentoService.getDipartimenti();
			return ResponseEntity.ok(dipartimenti);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@PostMapping("/add")
	public ResponseEntity<Void> addDipartimento(@Valid @RequestBody DipartimentoAddDto dipartimentoDto) {
		try {
			if (dipartimentoService.existsByNome(dipartimentoDto.getNome())) {
				return ResponseEntity.badRequest().build();
			}
			dipartimentoService.addDipartimento(dipartimentoDto);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteDipartimento(@PathVariable("id") int id){
		try {
			boolean deleted = dipartimentoService.deleteDipartimentoById(id);
			if(deleted) {
				return ResponseEntity.ok().build();
			}
			else {
				return ResponseEntity.badRequest().build();
			}
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
}
