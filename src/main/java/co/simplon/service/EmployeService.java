package co.simplon.service;

import java.util.List;
import java.util.Set;

import co.simplon.model.Utilisateur;

/**
 * 
 * Service lié aux actions sur un employe de la creche
 *	ajout, lecture, suppression, mise a jour
 *	d'un employe
 */

public interface EmployeService {

	Set<Utilisateur> getAllEmploye ();
	Utilisateur addEmploye (Utilisateur employe);
	Utilisateur getEmploye (Long id);
	Utilisateur updateEmploye (Utilisateur employe);
	void deleteEmploye (Utilisateur employe);
	
}
