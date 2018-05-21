package co.simplon.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import co.simplon.controller.dto.EmployeDto;
import co.simplon.controller.dto.EnfantDto;
import co.simplon.controller.dto.ParentDto;
import co.simplon.controller.mapper.EnfantMapper;
import co.simplon.controller.mapper.UtilisateurMapper;
import co.simplon.exception.MotDePasseException;
import co.simplon.model.Enfant;
import co.simplon.service.SectionService;
import co.simplon.service.UtilisateurService;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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

	private static final Logger logger = LogManager.getLogger(ParentServiceImpl.class);

	@Autowired
	private ParentDao parentDao;

	@Autowired
	private UtilisateurService utilisateurService;
	
	@Autowired 
	private ProfilService profilService;

	@Autowired
	private UtilisateurMapper utilisateurMapper;

	@Autowired
	private SectionService sectionService;

	@Autowired
	private EnfantMapper enfantMapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Set<ParentDto> getAllParents() {
		logger.info("recuperation du profil");
		Profil profil = this.profilService.getProfilByLibelle(ProfilEnum.PARENT);

		return this.utilisateurMapper.mapListUtilisateurToParentDto(this.parentDao.findByProfil(profil));
	}

	@Override
	public ParentDto createUtilisateurParent(ParentDto parentDto) throws MotDePasseException,MySQLIntegrityConstraintViolationException {
		Utilisateur utilisateur = this.utilisateurMapper.ParentDtoToUtilisateur(parentDto);
		utilisateur.setCreatedDate(LocalDateTime.now());

		//encodage mot de passe
		if(parentDto.getMotDePasse() != null) {
			utilisateur.setMotDePasse(this.passwordEncoder.encode(parentDto.getMotDePasse()));
		}else{
			throw new MotDePasseException("Mot de passe vide");
		}

		//attribution du profil parent
		utilisateur.setProfil(this.profilService.getProfilByLibelle(parentDto.getProfil()));
		return this.utilisateurMapper.utilisateurToParentDto(this.parentDao.save(utilisateur));
	}

	@Override
	public ParentDto getParent(Long id) {
		Utilisateur utilisateur = this.parentDao.findOne(id);
		logger.info("recuperation du parent  : " + utilisateur.toString());
		return this.utilisateurMapper.utilisateurToParentDto(utilisateur);
	}

	@Override
	public ParentDto updateParent(ParentDto parent) {
		Utilisateur utilisateur = this.utilisateurMapper.map(this.utilisateurService.getUtilisateur(parent.getId()));
		utilisateur.setUpdatedDate(LocalDateTime.now());
		Utilisateur utilisateurUpdated = this.utilisateurMapper.ParentDtoToUtilisateur(parent);

		//verification nouveau mot de passe different de l'ancien
		//recuperation et encodage du nouveau mot de passe
		if(!utilisateur.getMotDePasse().equals(utilisateurUpdated.getMotDePasse())) {
			String NewMotDePasse = this.passwordEncoder.encode(utilisateurUpdated.getMotDePasse());
			utilisateur.setMotDePasse(NewMotDePasse);
		}

		utilisateur.setInfo(utilisateurUpdated.getInfo());
		//utilisateur.getInfo().setEmail(utilisateurUpdated.getInfo().getEmail());
		List<Enfant> listeEnfants = new ArrayList<>();
		if((utilisateur.getEnfants() == null && parent.getEnfants() != null) || utilisateur.getEnfants().size() < parent.getEnfants().size()){
			//utilisateur.setEnfants(utilisateurUpdated.getEnfants());
			for (EnfantDto enfant : parent.getEnfants()){
				Enfant temp = this.enfantMapper.enfantDtoToEnfant(enfant);
				temp.setSection(this.sectionService.getSectionByNom(enfant.getSection()));
				listeEnfants.add(temp);
			}
			utilisateur.setEnfants(listeEnfants);
			//utilisateur.getEnfants().stream().forEach( (enfant) -> enfant.setSection());
		}


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
