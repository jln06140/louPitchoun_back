package co.simplon.controller;

import java.util.List;

import javax.validation.Valid;

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

import co.simplon.model.Employe;
import co.simplon.model.Parent;
import co.simplon.model.Utilisateur;
import co.simplon.service.EmployeService;
import co.simplon.service.ParentService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ParentController extends Utilisateur {

	@Autowired
	private ParentService parentService;
	
	
	/*
	 * @return
	 * Retourne tous les parents
	 */
	
	@GetMapping("/parent")
	List<Parent> getAllParent(){
		return this.parentService.getAllParent();
	}
	
	/*
	 *@param id du parent
	 *@return
	 *retourne un parent
	 */
	
	@GetMapping("/parent/{id}")
	ResponseEntity<Parent> getEmployeById (@PathVariable(value="id") long id){
		Parent parent = this.parentService.getParent(id);
		if( parent == null )
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok().body(parent);
	}
	
	/**
	 * @param parent
	 * @return
	 * creation et ajout d'un nouveau parent
	 */
	
	@PostMapping("/parent")
	Parent addParent(@Valid @RequestBody Parent parent) {
		return this.parentService.addParent(parent);
	}
	
	/**
	 * @param id parent
	 * @param parent
	 * @return
	 * mise a jour d'un parent
	 */
	
	@PutMapping("/parent/{id}")
	ResponseEntity<Parent> updateParent(@PathVariable(value = "id") Long id,@Valid @RequestBody Parent parent){
		Parent parentToUpdate = this.parentService.getParent(id);
		if (parentToUpdate == null)
			return ResponseEntity.notFound().build();
		
		parentToUpdate.setNom(parent.getNom());
		parentToUpdate.setPrenom(parent.getPrenom());
		parentToUpdate.setDateDeNaissance(parent.getDateDeNaissance());
		parentToUpdate.setAdresse(parent.getAdresse());
		parentToUpdate.setAdressePro(parent.getAdressePro());
		parentToUpdate.setEmail(parent.getEmail());
		parentToUpdate.setTelFixe(parent.getTelFixe());
		parentToUpdate.setTelMobile(parent.getTelMobile());
		parentToUpdate.setTelPro(parent.getTelPro());
		
		
		Parent parentUpdated = this.parentService.updateParent(parentToUpdate);
		return ResponseEntity.ok(parentUpdated);
	}
	
	/**
	 * @param id parent
	 * @return
	 * @suppression d'un parent
	 */
	
	@DeleteMapping("/parent/{id}")
	ResponseEntity<Parent> deleteParent(@PathVariable(value="id") Long id){
			Parent parent = this.parentService.getParent(id);
			if(parent == null)
				return ResponseEntity.notFound().build();
			
			this.parentService.deleteParent(parent);
			return ResponseEntity.ok().build();
		}
		
	}

