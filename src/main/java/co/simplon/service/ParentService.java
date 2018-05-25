package co.simplon.service;

import java.util.List;
import java.util.Set;

import co.simplon.controller.dto.EmployeDto;
import co.simplon.controller.dto.EnfantDto;
import co.simplon.controller.dto.ParentDto;
import co.simplon.exception.MotDePasseException;
import co.simplon.model.Utilisateur;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;


/**
 * 
 * Service lié aux actions sur un parent
 *	ajout, lecture, suppression, mise a jour
 *	d'un parent
 */
public interface ParentService {
	Set<ParentDto> getAllParents();
	ParentDto createUtilisateurParent(ParentDto parentDto) throws MotDePasseException, MySQLIntegrityConstraintViolationException;
	ParentDto getParent( Long id);

	ParentDto updateParent( ParentDto parent);

    ParentDto ajoutEnfantAuParent(Long parentId, List<EnfantDto> listeEnfants);

    void deleteParent (ParentDto parent);
}

