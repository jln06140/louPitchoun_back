package co.simplon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.enums.ProfilEnum;
import co.simplon.model.Profil;
import co.simplon.service.ProfilService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class profilController {
	
	@Autowired
	private ProfilService profilService;
	
	@CrossOrigin
	@GetMapping("/profil")
	List<Profil> getAllProfil(){
		return this.profilService.getAllProfils();
	}
	
	@CrossOrigin
	@GetMapping("/profil/{libelle}")
	ResponseEntity<Profil> getProfilByLibelle(@PathVariable (value = "libelle") String libelle) {
		Profil profil = this.profilService.getProfilByLibelle(ProfilEnum.valueOf(libelle.toUpperCase()));
		return ResponseEntity.ok().body(profil);
	}
	

}
