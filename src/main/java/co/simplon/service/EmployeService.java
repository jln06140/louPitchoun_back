package co.simplon.service;

import java.util.List;
import java.util.Set;

import co.simplon.controller.dto.EmployeDto;
import co.simplon.model.Utilisateur;

/**
 * 
 * Service lié aux actions sur un employe de la creche
 *	ajout, lecture, suppression, mise a jour
 *	d'un employe
 */

public interface EmployeService {

	Set<EmployeDto> getAllEmploye ();
	EmployeDto addEmploye (EmployeDto employe);
	EmployeDto getEmploye (Long id);
	EmployeDto updateEmploye (EmployeDto employe);
	void deleteEmploye (EmployeDto employe);
	
}
