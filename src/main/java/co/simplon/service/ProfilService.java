package co.simplon.service;

import java.util.List;

import co.simplon.enums.ProfilEnum;
import co.simplon.model.Profil;

public interface ProfilService {
	
	Profil getProfilByLibelle(ProfilEnum libelle);
	Profil getProfil(Long id);
	List<Profil> getAllProfils();
	Profil addProfil(Profil profil);

}
