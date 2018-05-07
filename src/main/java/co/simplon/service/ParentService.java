package co.simplon.service;

import java.util.Set;

import co.simplon.controller.dto.EmployeDto;
import co.simplon.controller.dto.ParentDto;
import co.simplon.model.Utilisateur;


/**
 * 
 * Service lié aux actions sur un parent
 *	ajout, lecture, suppression, mise a jour
 *	d'un parent
 */
public interface ParentService {
	Set<ParentDto> getAllParents();
	ParentDto createUtilisateurParent(ParentDto parentDto);
	ParentDto getParent( Long id);

	ParentDto updateParent( ParentDto parent);
	void deleteParent (ParentDto parent);
}

