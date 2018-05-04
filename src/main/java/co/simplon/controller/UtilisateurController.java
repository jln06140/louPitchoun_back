package co.simplon.controller;

import java.util.List;

import javax.validation.Valid;

import bzh.tibus29.spring.metrik.Metrik;
import co.simplon.controller.dto.UserDto;
import co.simplon.controller.dto.UtilisateurDto;
import co.simplon.controller.mapper.UtilisateurMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.controller.dto.ParentDto;
import co.simplon.model.Utilisateur;
import co.simplon.service.EmployeService;
import co.simplon.service.ParentService;
import co.simplon.service.UtilisateurService;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@RequestMapping("/utilisateur")
public class UtilisateurController {

	@Autowired
	private UtilisateurService utilisateurService;
	
	@Autowired
	private ParentService parentService;
	
	@Autowired
	private EmployeService employeService;

	@Autowired
	private UtilisateurMapper utilisateurMapper;

	/*
	 * @return
	 * Retourne tous les Utilisateurs
	 * 
	 */

	/*private ParentDto getPersonDTOFromJson(final String jsoParentDto) throws IOException {
        return objectMapper.setDateFormat(simpleDateFormat).readValue(jsonPersonDTO, PersonDTO.class);
    }*/
	
	@GetMapping
	@ApiOperation("Lecture d'un utilisateur")
	List<UtilisateurDto> getAllUtilisateur(){
		return this.utilisateurMapper.map(this.utilisateurService.getAllUtilisateurs());
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
	
	@GetMapping("/{id}")
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
	
	@PostMapping
	@Metrik(params = { "utilisateur.login" })
	UtilisateurDto create(@Valid @RequestBody UtilisateurDto utilisateur) {
		return this.utilisateurMapper.map(this.utilisateurService.createUtilisateur(utilisateur));
	}


	@PostMapping("/parent")
	Utilisateur addUtilisateurParent(@Valid @RequestBody ParentDto parentDto) {
		String s;
		//return this.utilisateurService.createUtilisateur(this.utilisateurMapper.map(parentDto));
		return null;
	}

	/**
	 * @param id utilisateur
	 * @param utilisateur
	 * @return
	 * mise a jour d'un utilisateur
	 */
	
	@PutMapping("/{id}")
	ResponseEntity<Utilisateur> updateUtilisateur(@PathVariable(value = "id") Long id,@Valid @RequestBody Utilisateur utilisateur){
		Utilisateur utilisateurToUpdate = this.utilisateurService.getUtilisateur(id);
		if (utilisateurToUpdate == null)
			return ResponseEntity.notFound().build();
		
		utilisateurToUpdate.setMotDePasse(utilisateur.getMotDePasse());
		utilisateurToUpdate.setActif(utilisateur.isActif());
		utilisateurToUpdate.setProfil(utilisateur.getProfil());
		//utilisateurToUpdate.setInfo(utilisateur.getInfo());
		
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
	
	@DeleteMapping("/{id}")
	ResponseEntity<Utilisateur> deleteUtilisateur(@PathVariable(value="id") Long id){
		Utilisateur utilisateur = this.utilisateurService.getUtilisateur(id);
		if(utilisateur == null)
			return ResponseEntity.notFound().build();
		
		this.utilisateurService.deleteUtilisateur(utilisateur);
		return ResponseEntity.ok().build();
	}
}
