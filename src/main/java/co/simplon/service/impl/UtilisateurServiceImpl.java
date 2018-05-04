package co.simplon.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


import co.simplon.controller.dto.UserDto;
import co.simplon.controller.dto.UtilisateurDto;
import co.simplon.exception.PitchounErrorEnum;
import co.simplon.exception.PitchounException;
import co.simplon.service.ProfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import co.simplon.dao.UtilisateurDao;
import co.simplon.model.Utilisateur;
import co.simplon.service.UtilisateurService;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

	@Autowired
	private ProfilService profilService;

	@Autowired
	private UtilisateurDao utilisateurDao;

	@Autowired
	private PasswordEncoder passwordEncoder;

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
		//utilisateur.setUpdatedDate(LocalDateTime.now());
		return this.utilisateurDao.save(utilisateur);
	}

	@Override
	public Utilisateur createUtilisateur(UtilisateurDto utilisateur) {

		final Utilisateur utilisateurToCreate = new Utilisateur();
		//utilisateurToCreate.setCreatedDate(LocalDateTime.now());
		utilisateurToCreate.setActif(true);
		utilisateurToCreate.setMotDePasse(this.passwordEncoder.encode(utilisateur.getMotDePasse()));
		utilisateurToCreate.setEmail(utilisateur.getEmail());
		utilisateurToCreate.setProfil(this.profilService.getProfilByLibelle(utilisateur.getProfil()));

		return this.utilisateurDao.save(utilisateurToCreate);
	}


	@Override
	public void deleteUtilisateur(Utilisateur utilisateur) {
		this.utilisateurDao.delete(utilisateur);
		
	}

	@Override
	public Utilisateur getByLogAndPass(String log, String mdp) throws Exception {
		Utilisateur utilisateur = this.utilisateurDao.findByEmail(log);
		if (utilisateur == null) {
			throw new Exception();
		}
		return utilisateur;	
	}

    @Override
    public Utilisateur findByEmail(String email) {
		final Utilisateur user = this.utilisateurDao.findByEmail(email);

		if(user == null) {
			throw new PitchounException(PitchounErrorEnum.USER_NOT_FOUND);
		}

		return user;
    }
}
