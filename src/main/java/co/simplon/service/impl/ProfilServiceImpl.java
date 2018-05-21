package co.simplon.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.dao.ProfilDao;
import co.simplon.enums.ProfilEnum;
import co.simplon.model.Profil;
import co.simplon.service.ProfilService;

@Service
public class ProfilServiceImpl implements ProfilService{

	@Autowired
	private ProfilDao profilDao;

	@Override
	public Profil getProfilByLibelle(ProfilEnum libelle) {
		return this.profilDao.findByLibelle(libelle).get(0);
	}

	@Override
	public Profil getProfil( Long id) {
		return this.profilDao.findOne(id);
	}

	@Override
	public List<Profil> getAllProfils() {
		return this.profilDao.findAll();
	}

	@Override
	public Profil addProfil( Profil profil ) {
		return this.profilDao.save(profil);
	}

	@Override
	public List<String> getAllLibelleProfils() {
		List<Profil> listeProfils = getAllProfils();
		List<String> listeLibelleProfils = new ArrayList<>();
		listeProfils.stream().forEach(profil -> listeLibelleProfils.add(profil.getLibelle().toString()));
		return listeLibelleProfils;
	}
}
