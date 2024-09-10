package it.corso.controller;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.corso.dto.UtenteAddDto;
import it.corso.dto.UtenteAggiornaDto;
import it.corso.dto.UtenteDto;
import it.corso.service.UtenteService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/utente")
public class UtenteController {
    
	@Autowired
	private UtenteService utenteService;
	
	@PutMapping("/aggiorna")
	public ResponseEntity<Void> updateUtente(@Valid @RequestBody UtenteAggiornaDto utente){
		
		
		try {
			if (!Pattern.matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,20}",
					utente.getPassword())) {
				return ResponseEntity.badRequest().build();
			}
			utenteService.updateUtente(utente);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping("/get/id/{id}")
    public ResponseEntity<UtenteDto> getUtenteById(@PathVariable("id") int id){
    try {
        if(id!=0) {
            UtenteDto utenteDto =utenteService.getUtenteById(id);
            if(utenteDto!=null) {
                return ResponseEntity.ok(utenteDto);
            }else {
                return ResponseEntity.badRequest().build();
            }
        }
        return ResponseEntity.badRequest().build();
    } catch (Exception e) {
        return ResponseEntity.badRequest().build();
    }  
    }
   
   
    @GetMapping("/get/Bydipartimento")
    public ResponseEntity<List<UtenteDto>> getUtenteByDipartimento(@RequestParam("dipartimento") String dipartimento){
    try {
        if(dipartimento!=null && !dipartimento.isEmpty()) {
            List<UtenteDto> utentiDto = utenteService.getUtenteByDipartimento(dipartimento);
            if(utentiDto!=null) {
                return ResponseEntity.ok(utentiDto);
            }else {
                return ResponseEntity.badRequest().build();
            }
        }
        return ResponseEntity.badRequest().build();
    } catch (Exception e) {
        return ResponseEntity.badRequest().build();
    }  
    }
   
   
    @GetMapping("/get/byRuolo")
    public ResponseEntity<List<UtenteDto>> getUtenteByRuolo(@RequestParam("ruolo") String ruolo){
        try {
            if(ruolo!=null && !ruolo.isEmpty()) {
                List<UtenteDto> utentiDto = utenteService.getUtenteByRuolo(ruolo);
                if(utentiDto!=null) {
                    return ResponseEntity.ok(utentiDto);
                }else {
                    return ResponseEntity.badRequest().build();
                }
            }
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }  
    }
   
   
    @GetMapping("/get/byNomeEcognome")
    public ResponseEntity<List<UtenteDto>> getUtenteByNomeAndCognome(@RequestParam("nome") String nome,@RequestParam("cognome") String cognome){
        try {
            if(nome!=null && !nome.isEmpty() && cognome!=null && !cognome.isEmpty()) {
                List<UtenteDto> utentiDto = utenteService.getUtenteByNomeECognome(nome, cognome);
                if(utentiDto!=null) {
                    return ResponseEntity.ok(utentiDto);
                }else {
                    return ResponseEntity.badRequest().build();
                }
            }
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }  
    }
    
    @PostMapping("/add")
	public ResponseEntity<Void> saveProduct(@Valid @RequestBody UtenteAddDto utenteAddDto) {
 
		try {
			if (!Pattern.matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,20}",
					utenteAddDto.getPassword())) {
				return ResponseEntity.badRequest().build();
			}
			utenteService.addUtente(utenteAddDto);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
 
	}
    
    @GetMapping("/get/all")
	public ResponseEntity<List<UtenteDto>> getUtenti() {
		try {
			
			List<UtenteDto> utenti = utenteService.getUtenti();
			
			return ResponseEntity.ok(utenti);
			
		} catch (Exception e) {
			
			return ResponseEntity.badRequest().build();
			
		}
	}
    
    @DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteUtente(@PathVariable("id") int id) {
		try {
			utenteService.deleteUtenteById(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
 
}
