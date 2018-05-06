package co.simplon.service.impl;

import java.util.List;
import java.util.stream.Collectors;


import co.simplon.controller.dto.EmployeDto;
import co.simplon.controller.dto.ParentDto;
import co.simplon.controller.dto.UtilisateurDto;
import co.simplon.controller.mapper.UtilisateurMapper;
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

	@Autowired
	private UtilisateurMapper utilisateurMapper;


	@Override
	public UtilisateurDto createUtilisateur(UtilisateurDto utilisateurDto) {
		Utilisateur utilisateurToCreate = this.utilisateurMapper.map(utilisateurDto);
		utilisateurToCreate.setProfil(this.profilService.getProfilByLibelle(utilisateurDto.getProfil()));
		return this.utilisateurMapper.map(this.utilisateurDao.save(utilisateurToCreate));

	}

	public ParentDto createUtilisateurParent(ParentDto parentDto){
		Utilisateur utilisateur = this.utilisateurMapper.ParentDtoToUtilisateur(parentDto);
		return this.utilisateurMapper.utilisateurToParentDto(this.utilisateurDao.save(utilisateur));
	}

	public EmployeDto createUtilisateurEmploye(EmployeDto employeDto){
		Utilisateur utilisateurToCreate = this.utilisateurMapper.mapEmploye(employeDto);
		return this.utilisateurMapper.mapEmploye(this.utilisateurDao.save(utilisateurToCreate));
	}

	@Override
	public List<Utilisateur> getAllUtilisateurs() {
		return this.utilisateurDao.findAll();
	}

	@Override
	public List<Utilisateur> getAllUtilisateursParent() {
		return this.utilisateurDao.findAll().stream()
				.filter(user -> user.getProfil().getLibelle().toString().equals("PARENT"))
				.collect(Collectors.toList());
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
	public void deleteUtilisateur(Utilisateur utilisateur) {
		this.utilisateurDao.delete(utilisateur);
		
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
