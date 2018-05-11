package co.simplon.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


import co.simplon.controller.dto.EmployeDto;
import co.simplon.controller.dto.ParentDto;
import co.simplon.controller.dto.UtilisateurDto;
import co.simplon.controller.mapper.UtilisateurMapper;
import co.simplon.service.ProfilService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import co.simplon.dao.UtilisateurDao;
import co.simplon.model.Utilisateur;
import co.simplon.service.UtilisateurService;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

	private static final Logger logger = LogManager.getLogger(UtilisateurServiceImpl.class);

	@Autowired
	private ProfilService profilService;

	@Autowired
	private UtilisateurDao utilisateurDao;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UtilisateurMapper utilisateurMapper;


	@Override
	public UtilisateurDto createUtilisateur(UtilisateurDto utilisateurDto) {
		Utilisateur utilisateurToCreate = this.utilisateurMapper.map(utilisateurDto);
		utilisateurToCreate.setCreatedDate(LocalDateTime.now());
		utilisateurToCreate.setProfil(this.profilService.getProfilByLibelle(utilisateurDto.getProfil()));
		return this.utilisateurMapper.map(this.utilisateurDao.save(utilisateurToCreate));

	}

	public ParentDto createUtilisateurParent(ParentDto parentDto){
		Utilisateur utilisateur = this.utilisateurMapper.ParentDtoToUtilisateur(parentDto);
		utilisateur.setCreatedDate(LocalDateTime.now());
		return this.utilisateurMapper.utilisateurToParentDto(this.utilisateurDao.save(utilisateur));
	}

	public EmployeDto createUtilisateurEmploye(EmployeDto employeDto){
		Utilisateur utilisateurToCreate = this.utilisateurMapper.mapEmploye(employeDto);
		return this.utilisateurMapper.mapEmploye(this.utilisateurDao.save(utilisateurToCreate));
	}

	@Override
	public List<UtilisateurDto> getAllUtilisateurs() {
		logger.info("recuperation des utilisateurs");
		return this.utilisateurMapper.map(this.utilisateurDao.findAll());
	}

	@Override
	public List<Utilisateur> getAllUtilisateursParent() {
		return this.utilisateurDao.findAll().stream()
				.filter(user -> user.getProfil().getLibelle().toString().equals("PARENT"))
				.collect(Collectors.toList());
	}


	@Override
	public UtilisateurDto getUtilisateur(Long id) {
		Utilisateur utilisateur = this.utilisateurDao.findOne(id);
		logger.info("recuperation utilisateur : " + utilisateur.getInfo().getPrenom());
		return this.utilisateurMapper.map(utilisateur);
	}

	@Override
	public UtilisateurDto updateUtilisateur(UtilisateurDto utilisateur) {
		//utilisateur.setUpdatedDate(LocalDateTime.now());
		Utilisateur utilisateurToUpdate = this.utilisateurMapper.map(utilisateur);
		return this.utilisateurMapper.map(this.utilisateurDao.save(utilisateurToUpdate));
	}

	@Override
	public void deleteUtilisateur(UtilisateurDto utilisateurDto) {
		Utilisateur utilisateurToDelete = this.utilisateurMapper.map(utilisateurDto);
		this.utilisateurDao.delete(utilisateurToDelete);

	}



   /* @Override
    public Utilisateur findByEmail(String email) {
		final Utilisateur user = this.utilisateurDao.findByEmail(email);

		if(user == null) {
			throw new PitchounException(PitchounErrorEnum.USER_NOT_FOUND);
		}

		return user;
    }*/


}
