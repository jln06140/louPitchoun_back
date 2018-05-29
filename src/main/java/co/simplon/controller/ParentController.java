package co.simplon.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import co.simplon.controller.dto.EnfantDto;
import co.simplon.controller.dto.ParentDto;
import co.simplon.dao.ParentDao;
import co.simplon.exception.MotDePasseException;
import co.simplon.service.EnfantService;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
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


import co.simplon.service.EmployeService;
import co.simplon.service.ParentService;

@RestController
@CrossOrigin
@RequestMapping("/parent")
public class ParentController{

	@Autowired
	private ParentService parentService;

	@Autowired
	private EnfantService enfantService;


	/*
	 * @return
	 * Retourne tous les parents
	 */

	@GetMapping
    List<ParentDto> getAllParent(){
		return this.parentService.getAllParents();
	}


	/*
	 *@param id du parent
	 *@return
	 *retourne un parent
	 */

	@GetMapping("/{id}")
	ResponseEntity<ParentDto> getParent (@PathVariable(value="id") long id){
        ParentDto parent = this.parentService.getParent(id);
		if( parent == null )
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok().body(parent);
	}

	@GetMapping("/parentsenfant/{id}")
	ResponseEntity<EnfantDto> getParentsEnfant (@PathVariable(value="id") Long enfantId){
		EnfantDto enfant = this.enfantService.getEnfant(enfantId);
		if( enfant == null )
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok().body(enfant);
	}

	/**
	 * @param parent
	 * @return
	 * creation et ajout d'un nouveau parent
	 */
	@PostMapping
    ResponseEntity<Object> addParent(@Valid @RequestBody ParentDto parent) {
		ParentDto parentCreated = new ParentDto();
		try{
			parentCreated = this.parentService.createUtilisateurParent(parent);
			return ResponseEntity.ok().body(parentCreated);
		}
		catch(MotDePasseException e){
			Map<String,String> resultMap = new HashMap<>();
			resultMap.put("message","Mot de passe obligatoire");
			return ResponseEntity.badRequest().body(resultMap);
		}catch(Exception e){
			Map<String,String> resultMap = new HashMap<String,String>();
			resultMap.put("message","Parent deja enregistré avec cet email");
			return ResponseEntity.badRequest().body(resultMap);
		}

	}

	@PostMapping("/ajoutenfant/{id}")
	ResponseEntity<Object> addEnfantToParent(@PathVariable(value = "id") Long parentId, @Valid @RequestBody List<EnfantDto> enfantsAajouter) {
			ParentDto parentDto = this.parentService.ajoutEnfantAuParent(parentId, enfantsAajouter);
			return ResponseEntity.ok().body(parentDto);


	}

	/**
	 * @param id parent
	 * @param parent
	 * @return
	 * mise a jour d'un parent
	 */

	@PutMapping("/{id}")
	ResponseEntity<Object> updateParent(@PathVariable(value = "id") Long id,@Valid @RequestBody ParentDto parent){
        ParentDto parentToUpdate = this.parentService.getParent(id);
		if (parentToUpdate == null)
			return ResponseEntity.notFound().build();
		try{
			ParentDto parentUpdated = this.parentService.updateParent(parent);
			return ResponseEntity.ok(parentUpdated);
		}catch(Exception e){
			Map<String,String> resultMap = new HashMap<String,String>();
			resultMap.put("message","Email deja utilisé");
			return ResponseEntity.badRequest().body(resultMap);
		}
	}

	/**
	 * @param id parent
	 * @return
	 * @suppression d'un parent
	 */

	@DeleteMapping("/{id}")
	ResponseEntity<ParentDto> deleteParent(@PathVariable(value="id") Long id){
        ParentDto parent = this.parentService.getParent(id);
			if(parent == null)
				return ResponseEntity.notFound().build();

			this.parentService.deleteParent(parent);
			return ResponseEntity.ok().build();
		}

	}

