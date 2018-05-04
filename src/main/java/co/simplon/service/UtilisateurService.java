package co.simplon.service;

import java.util.List;
import java.util.Optional;

import co.simplon.controller.dto.UserDto;
import co.simplon.controller.dto.UtilisateurDto;
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

	Utilisateur createUtilisateur(UtilisateurDto utilisateur);

	void deleteUtilisateur( Utilisateur utilisateur);

	Utilisateur getByLogAndPass(String log, String mdp) throws Exception;

	Utilisateur findByEmail(String username);
}
