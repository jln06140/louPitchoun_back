package co.simplon.service;

import java.util.List;

import co.simplon.model.Utilisateur;

/**
 * 
 * Service lié aux actions sur un utilisateur de la creche
 *	ajout, lecture, suppression, mise a jour
 *	d'un utilisateur
 */

public interface UtilisateurService {

	List <Utilisateur> getAllUtilisateurs();
	Utilisateur getUtilisateur( Long id );
	Utilisateur updateUtilisateur( Utilisateur utilisateur);
	Utilisateur createUtilisateur( Utilisateur utilisateur);
	void deleteUtilisateur( Utilisateur utilisateur);
	Utilisateur getByLogAndPass(String log, String mdp) throws Exception;
 }
