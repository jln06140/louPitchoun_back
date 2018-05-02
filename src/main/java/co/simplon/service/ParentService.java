package co.simplon.service;

import java.util.Set;

import co.simplon.model.Utilisateur;


/**
 * 
 * Service lié aux actions sur un parent
 *	ajout, lecture, suppression, mise a jour
 *	d'un parent
 */
public interface ParentService {
	Set<Utilisateur> getAllParent();
	Utilisateur addParent (Utilisateur parent);
	Utilisateur getParent( Long id);
	Utilisateur updateParent( Utilisateur parent);
	void deleteParent (Utilisateur parent);
}

