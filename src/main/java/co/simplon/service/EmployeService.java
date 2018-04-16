package co.simplon.service;

import java.util.List;

import co.simplon.model.Employe;

/**
 * 
 * Service lié aux actions sur un employe de la creche
 *	ajout, lecture, suppression, mise a jour
 *	d'un employe
 */

public interface EmployeService {

	List<Employe> getAllEmploye ();
	Employe addEmploye (Employe employe);
	Employe getEmploye (Long id);
	Employe updateEmploye (Employe employe);
	void deleteEmploye (Employe employe);
	
}
