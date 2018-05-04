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
@RequestMapping("/profil")
public class ProfilController {
	
	@Autowired
	private ProfilService profilService;

	@GetMapping
	List<Profil> getAllProfil(){
		return this.profilService.getAllProfils();
	}

	@GetMapping("/{libelle}")
	Profil getProfilByLibelle(@PathVariable (value = "libelle") String libelle) {
		return this.profilService.getProfilByLibelle(ProfilEnum.valueOf(libelle.toUpperCase()));
	}
}
