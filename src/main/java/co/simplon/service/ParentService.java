package co.simplon.service;

import java.util.List;

import co.simplon.model.Employe;
import co.simplon.model.Parent;

/**
 * 
 * Service lié aux actions sur un parent
 *	ajout, lecture, suppression, mise a jour
 *	d'un parent
 */

public interface ParentService {

	List<Parent> getAllParent ();
	Parent addParent (Parent parent);
	Parent getParent (Long id);
	Parent updateParent (Parent parent);
	void deleteParent (Parent parent);
	
}
