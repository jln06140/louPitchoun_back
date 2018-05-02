package co.simplon.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.dao.ParentDao;
import co.simplon.enums.ProfilEnum;
import co.simplon.model.Profil;
import co.simplon.model.Utilisateur;
import co.simplon.service.ParentService;
import co.simplon.service.ProfilService;

/*
 * Service lié a un parent qui est un uitilsateur
 */

@Service
public class ParentServiceImpl implements ParentService{

	@Autowired
	private ParentDao parentDao;
	
	@Autowired 
	private ProfilService profilService;

	@Override
	public Set<Utilisateur> getAllParent() {
		Profil profil = this.profilService.getProfilByLibelle(ProfilEnum.PARENT);
		return this.parentDao.findByProfil(profil);
	}

	@Override
	public Utilisateur addParent(Utilisateur parent) {
		return this.parentDao.save(parent);
	}

	@Override
	public Utilisateur getParent(Long id) {
		return this.parentDao.findOne(id);
	}

	@Override
	public Utilisateur updateParent(Utilisateur parent) {
		return this.parentDao.save(parent);
	}

	@Override
	public void deleteParent(Utilisateur parent) {
		this.parentDao.delete(parent);
		
	}

		  
}
