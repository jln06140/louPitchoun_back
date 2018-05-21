package co.simplon.service;

import java.util.Set;

import co.simplon.controller.dto.EmployeDto;
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
	void deleteParent (ParentDto parent);
}

