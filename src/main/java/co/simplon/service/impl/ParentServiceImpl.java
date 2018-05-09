package co.simplon.service.impl;

import java.time.LocalDateTime;
import java.util.Set;

import co.simplon.controller.dto.EmployeDto;
import co.simplon.controller.dto.ParentDto;
import co.simplon.controller.mapper.UtilisateurMapper;
import co.simplon.service.UtilisateurService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
	private UtilisateurService utilisateurService;
	
	@Autowired 
	private ProfilService profilService;

	@Autowired
	private UtilisateurMapper utilisateurMapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Set<ParentDto> getAllParents() {
		Profil profil = this.profilService.getProfilByLibelle(ProfilEnum.PARENT);

		return this.utilisateurMapper.mapListUtilisateurToParentDto(this.parentDao.findByProfil(profil));
	}

	public ParentDto createUtilisateurParent(ParentDto parentDto){
		Utilisateur utilisateur = this.utilisateurMapper.ParentDtoToUtilisateur(parentDto);
		return this.utilisateurMapper.utilisateurToParentDto(this.parentDao.save(utilisateur));
	}

	@Override
	public ParentDto getParent(Long id) {

		return this.utilisateurMapper.utilisateurToParentDto(this.parentDao.findOne(id));
	}

	@Override
	public ParentDto updateParent(ParentDto parent) {
		Utilisateur utilisateur = this.utilisateurMapper.map(this.utilisateurService.getUtilisateur(parent.getId()));
		Utilisateur utilisateurUpdated = this.utilisateurMapper.ParentDtoToUtilisateur(parent);

		//verification nouveau mot de passe different de l'ancien
		//recuperation et encodage du nouveau mot de passe
		if(!utilisateur.getMotDePasse().equals(utilisateurUpdated.getMotDePasse())) {
			String NewMotDePasse = this.passwordEncoder.encode(utilisateurUpdated.getMotDePasse());
			utilisateur.setMotDePasse(NewMotDePasse);
		}

		utilisateur.setInfo(utilisateurUpdated.getInfo());
		utilisateur.getInfo().setEmail(utilisateurUpdated.getInfo().getEmail());

		//recuperation du profil
		utilisateur.setProfil(this.profilService.getProfilByLibelle(parent.getProfil()));

		//mise a jour de la date de moddification
		utilisateur.setUpdatedDate(LocalDateTime.now());
		return this.utilisateurMapper.utilisateurToParentDto(this.parentDao.save(utilisateur));
	}

	@Override
	public void deleteParent(ParentDto parent) {

		this.parentDao.delete(this.utilisateurMapper.ParentDtoToUtilisateur(parent));
		
	}

		  
}
