package co.simplon.controller;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.simplon.controller.dto.ParentDto;
import co.simplon.model.Utilisateur;
import co.simplon.service.EmployeService;
import co.simplon.service.ParentService;
import co.simplon.service.UtilisateurService;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class UtilisateurController {

	@Autowired
	private UtilisateurService utilisateurService;
	
	@Autowired
	private ParentService parentService;
	
	@Autowired
	private EmployeService employeService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	/*
	 * @return
	 * Retourne tous les Utilisateurs
	 * 
	 */

	/*private ParentDto getPersonDTOFromJson(final String jsoParentDto) throws IOException {
        return objectMapper.setDateFormat(simpleDateFormat).readValue(jsonPersonDTO, PersonDTO.class);
    }*/
	
	@GetMapping("/utilisateur")
	@ApiOperation("Lecture d'un utilisateur")
	List<Utilisateur> getAllUtilisateur(){
		return this.utilisateurService.getAllUtilisateurs();
	}
	
	
	/*@GetMapping("/parent")
	Set<ParentDto> getAllParents(){
		return this.parentService.getAllParent();
	}*/
	
	
	/*
	 *@param id de l'utilisateur
	 *@return
	 *retourne un utilisateur
	 */
	
	@GetMapping("/utilisateur/{id}")
	ResponseEntity<Utilisateur> getUtilisateurById (@PathVariable(value="id") long id){
		Utilisateur utilisateur = this.utilisateurService.getUtilisateur(id);
		if( utilisateur == null )
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok().body(utilisateur);
	}
	
	/**
	 * @param utilisateur
	 * @return
	 * creation et ajout d'un nouvel utilisateur
	 */
	
	@PostMapping("/utilisateur")
	Utilisateur addUtilisateur(@Valid @RequestBody Utilisateur utilisateur) {
		return this.utilisateurService.createUtilisateur(utilisateur);
	}


	/*@PostMapping("/utilisateur/parent")
	Utilisateur addUtilisateurParent(@Valid @RequestBody ParentDto parentDto) {
		return this.utilisateurService.createUtilisateur(modelMapper.map(parentDto, ParentDto.class);
	}*/

	/**
	 * @param id utilisateur
	 * @param utilisateur
	 * @return
	 * mise a jour d'un utilisateur
	 */
	
	@PutMapping("/utilisateur/{id}")
	ResponseEntity<Utilisateur> updateUtilisateur(@PathVariable(value = "id") Long id,@Valid @RequestBody Utilisateur utilisateur){
		Utilisateur utilisateurToUpdate = this.utilisateurService.getUtilisateur(id);
		if (utilisateurToUpdate == null)
			return ResponseEntity.notFound().build();
		
		utilisateurToUpdate.setMotDePasse(utilisateur.getMotDePasse());
		utilisateurToUpdate.setActif(utilisateur.isActif());
		utilisateurToUpdate.setProfil(utilisateur.getProfil());
		utilisateurToUpdate.setCommonInfo(utilisateur.getCommonInfo());
		
		//TOdo
		//relier profil et les infos
		
		Utilisateur utilisateurRet = this.utilisateurService.updateUtilisateur(utilisateurToUpdate);
		return ResponseEntity.ok(utilisateurRet);
	}
	
	/**
	 * @param id utilisateur
	 * @return
	 * @suppression d'un utilisateur
	 */
	
	@DeleteMapping("/utilisateur/{id}")
	ResponseEntity<Utilisateur> deleteUtilisateur(@PathVariable(value="id") Long id){
		Utilisateur utilisateur = this.utilisateurService.getUtilisateur(id);
		if(utilisateur == null)
			return ResponseEntity.notFound().build();
		
		this.utilisateurService.deleteUtilisateur(utilisateur);
		return ResponseEntity.ok().build();
	}
	
	
	
}
