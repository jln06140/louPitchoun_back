package co.simplon.service.impl;

import java.util.List;

import co.simplon.model.ParentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.dao.UtilisateurDao;
import co.simplon.model.Utilisateur;
import co.simplon.service.UtilisateurService;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

	@Autowired
	private UtilisateurDao utilisateurDao;

	@Override
	public List<Utilisateur> getAllUtilisateurs() {
		return this.utilisateurDao.findAll();
	}

	@Override
	public Utilisateur getUtilisateur(Long id) {
		return this.utilisateurDao.findOne(id);
	}

	@Override
	public Utilisateur updateUtilisateur(Utilisateur utilisateur) {
		return this.utilisateurDao.save(utilisateur);
	}

	@Override
	public Utilisateur createUtilisateur(Utilisateur utilisateur) {
		if (utilisateur.isParent()){
			utilisateur.setCommonInfo((ParentInfo)utilisateur.getCommonInfo());
		}
		return this.utilisateurDao.save(utilisateur);
	}

	@Override
	public void deleteUtilisateur(Utilisateur utilisateur) {
		this.utilisateurDao.delete(utilisateur);
		
	}

	@Override
	public Utilisateur getByLogAndPass(String log, String mdp) throws Exception {
		Utilisateur utilisateur = this.utilisateurDao.findByLogin(log);
		if (utilisateur == null) {
			throw new Exception();
		}
		return utilisateur;	
	}


	
	

}
