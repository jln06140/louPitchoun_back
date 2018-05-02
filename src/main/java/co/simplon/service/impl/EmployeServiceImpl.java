package co.simplon.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.dao.EmployeDao;
import co.simplon.enums.ProfilEnum;
import co.simplon.model.Profil;
import co.simplon.model.Utilisateur;
import co.simplon.service.EmployeService;
import co.simplon.service.ProfilService;

@Service
public class EmployeServiceImpl implements EmployeService{

	@Autowired
	private EmployeDao daoEmploye;
	
	@Autowired
	private ProfilService profilService;

	@Override
	public Set<Utilisateur> getAllEmploye() {
		Profil profil = this.profilService.getProfilByLibelle(ProfilEnum.EMPLOYE);
		return this.daoEmploye.findByProfil(profil);
	}

	@Override
	public Utilisateur addEmploye(Utilisateur employe) {
		return this.daoEmploye.save(employe);
	}

	@Override
	public Utilisateur getEmploye(Long id) {
		return this.daoEmploye.findOne(id);
	}

	@Override
	public Utilisateur updateEmploye(Utilisateur employe) {
		return this.daoEmploye.save(employe);
	}

	@Override
	public void deleteEmploye(Utilisateur employe) {
		this.daoEmploye.delete(employe);
		
	}

}
