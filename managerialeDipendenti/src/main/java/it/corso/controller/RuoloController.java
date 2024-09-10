package it.corso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.corso.dto.UtenteRuoloDto;
import it.corso.service.RuoloService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/ruoli")
public class RuoloController {

	@Autowired
	private RuoloService ruoloService;


	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteRuolo(@PathVariable("id") int id) {
		try {
			boolean deleted = ruoloService.deleteRuolo(id);
			if(deleted) {
				return ResponseEntity.ok().build();
			}
			else {return ResponseEntity.notFound().build();}
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@PostMapping("/add")
	public ResponseEntity<Void> saveRuolo(@Valid @RequestBody UtenteRuoloDto utenteRuoloDto) {

		try {
			ruoloService.addRuolo(utenteRuoloDto);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}

	}

	@GetMapping("/get/all")
	public ResponseEntity<List<UtenteRuoloDto>> getRuoli() {
		try {
			List<UtenteRuoloDto> ruoli = ruoloService.getRuoli();
			return ResponseEntity.ok(ruoli);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
}
