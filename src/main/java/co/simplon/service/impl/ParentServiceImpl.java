package co.simplon.service.impl;

import java.util.Set;

import co.simplon.controller.dto.EmployeDto;
import co.simplon.controller.dto.ParentDto;
import co.simplon.controller.mapper.UtilisateurMapper;
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

	@Autowired
	private UtilisateurMapper utilisateurMapper;

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
		Utilisateur utilisateurToUpdate = this.utilisateurMapper.ParentDtoToUtilisateur(parent);
		return this.utilisateurMapper.utilisateurToParentDto(this.parentDao.save(utilisateurToUpdate));
	}

	@Override
	public void deleteParent(ParentDto parent) {

		this.parentDao.delete(this.utilisateurMapper.ParentDtoToUtilisateur(parent));
		
	}

		  
}
