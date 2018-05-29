package co.simplon.service;

import java.util.List;
import java.util.Set;

import co.simplon.controller.dto.EmployeDto;
import co.simplon.exception.MotDePasseException;
import co.simplon.model.Utilisateur;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

/**
 * 
 * Service lié aux actions sur un employe de la creche
 *	ajout, lecture, suppression, mise a jour
 *	d'un employe
 */

public interface EmployeService {

	List<EmployeDto> getAllEmploye ();
	EmployeDto addEmploye (EmployeDto employe) throws Exception;
	EmployeDto getEmploye (Long id);
	EmployeDto updateEmploye (EmployeDto employe);
	void deleteEmploye (EmployeDto employe);
	
}
