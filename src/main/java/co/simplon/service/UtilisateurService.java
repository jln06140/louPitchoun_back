package co.simplon.service;

import java.util.List;
import java.util.Optional;

import co.simplon.controller.dto.EmployeDto;
import co.simplon.controller.dto.ParentDto;
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

	UtilisateurDto createUtilisateur(UtilisateurDto utilisateurDto);

	ParentDto createUtilisateurParent(ParentDto parentDto);

	EmployeDto createUtilisateurEmploye(EmployeDto employeDto);

	List <UtilisateurDto> getAllUtilisateurs();

	List <Utilisateur> getAllUtilisateursParent();

	UtilisateurDto getUtilisateur( Long id );

	UtilisateurDto updateUtilisateur( UtilisateurDto utilisateur);

	void deleteUtilisateur( UtilisateurDto utilisateur);

	Utilisateur getUtilisateurByUsernameAndMdp(String username, String motDePasse) throws Exception;


	/*Utilisateur getByLogAndPass(String log, String mdp) throws Exception;

	Utilisateur findByEmail(String username);*/


}
