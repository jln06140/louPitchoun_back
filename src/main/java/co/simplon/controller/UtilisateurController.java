package co.simplon.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.rmi.CORBA.Util;
import javax.validation.Valid;

import bzh.tibus29.spring.metrik.Metrik;
import co.simplon.controller.dto.EmployeDto;
import co.simplon.controller.dto.UserDto;
import co.simplon.controller.dto.UtilisateurDto;

import co.simplon.controller.mapper.UtilisateurMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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
	@ApiOperation("Lecture de tous utilisateurs")
	List<UtilisateurDto> getAllUtilisateur(){
		return this.utilisateurService.getAllUtilisateurs();

	}

	/*@GetMapping("/parents")
	@ApiOperation("Lecture d'un utilisateur parent")
	Set<ParentDto> getAllUtilisateurParent(){
		return this.utilisateurMapper.mapListUtilisateurToParentDto(this.utilisateurService.getAllUtilisateursParent());
	}*/
	
	
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
	@ApiOperation("Lecture d'un utilisateur")
	ResponseEntity<UtilisateurDto> getUtilisateurById (@PathVariable(value="id") long id){
		UtilisateurDto utilisateur = this.utilisateurService.getUtilisateur(id);
		if( utilisateur == null )
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok().body(utilisateur);
	}

	@GetMapping("login")
	ResponseEntity<Object> getUtilisateurByusernameAndMdp(@RequestParam("log") String username,
															   @RequestParam("mdp") String motDePasse) throws Exception {
		try {
			Utilisateur utilisateurReturn = this.utilisateurService.getUtilisateurByUsernameAndMdp(username, motDePasse);
			UtilisateurDto utilisateurReturnDto = this.utilisateurMapper.map(utilisateurReturn);
			return ResponseEntity.ok().body(utilisateurReturnDto);
		}catch(Exception e){
			Map<String,String> resultMap = new HashMap<>();
			resultMap.put("message","Utilisateur inexistant");
			return ResponseEntity.badRequest().body(resultMap);
		}
	}
	
	/**
	 * @param utilisateur
	 * @return
	 * creation et ajout d'un nouvel utilisateur
	 */
	
	@PostMapping
	@Metrik(params = { "utilisateur.login" })
	UtilisateurDto create(@Valid @RequestBody UtilisateurDto utilisateur) {
		return this.utilisateurService.createUtilisateur(utilisateur);
	}


	@PostMapping("/parent")
	ParentDto createUtilisateurParent(@Valid @RequestBody ParentDto parentDto) {
		return this.utilisateurService.createUtilisateurParent(parentDto);
	}

	@PostMapping("/employe")
	EmployeDto createUtilisateurEmploye(@Valid @RequestBody EmployeDto employeDto){
		return this.utilisateurService.createUtilisateurEmploye(employeDto);
	}

	/**
	 * @param id utilisateur
	 * @param utilisateur
	 * @return
	 * mise a jour d'un utilisateur
	 */
	
	@PutMapping("/{id}")
	ResponseEntity<UtilisateurDto> updateUtilisateur(@PathVariable(value = "id") Long id,@Valid @RequestBody Utilisateur utilisateur){
		UtilisateurDto utilisateurToUpdate = this.utilisateurService.getUtilisateur(id);
		if (utilisateurToUpdate == null)
			return ResponseEntity.notFound().build();

		UtilisateurDto utilisateurRet = this.utilisateurService.updateUtilisateur(utilisateurToUpdate);
		return ResponseEntity.ok(utilisateurRet);
	}
	
	/**
	 * @param id utilisateur
	 * @return
	 * @suppression d'un utilisateur
	 */
	
	@DeleteMapping("/{id}")
	ResponseEntity<UtilisateurDto> deleteUtilisateur(@PathVariable(value="id") Long id){
		UtilisateurDto utilisateur = this.utilisateurService.getUtilisateur(id);
		if(utilisateur == null)
			return ResponseEntity.notFound().build();
		
		this.utilisateurService.deleteUtilisateur(utilisateur);
		return ResponseEntity.ok().build();
	}
}
