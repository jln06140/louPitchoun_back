package co.simplon.controller;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import co.simplon.controller.dto.ParentDto;
import co.simplon.dao.ParentDao;
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


	/*
	 * @return
	 * Retourne tous les parents
	 */

	@GetMapping
    Set<ParentDto> getAllParent(){
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

	/**
	 * @param parent
	 * @return
	 * creation et ajout d'un nouveau parent
	 */

	@PostMapping
    ParentDto addParent(@Valid @RequestBody ParentDto parent) {
		return this.parentService.createUtilisateurParent(parent);
	}

	/**
	 * @param id parent
	 * @param parent
	 * @return
	 * mise a jour d'un parent
	 */

	@PutMapping("/parent/{id}")
	ResponseEntity<ParentDto> updateParent(@PathVariable(value = "id") Long id,@Valid @RequestBody ParentDto parent){
        ParentDto parentToUpdate = this.parentService.getParent(id);
		if (parentToUpdate == null)
			return ResponseEntity.notFound().build();

		parentToUpdate.getInfoParent().setNom(parent.getInfoParent().getNom());
//		parentToUpdate.setPrenom(parent.getPrenom());
//		parentToUpdate.setDateDeNaissance(parent.getDateDeNaissance());
//		parentToUpdate.setAdresse(parent.getAdresse());
//		parentToUpdate.setAdressePro(parent.getAdressePro());
//		parentToUpdate.setEmail(parent.getUsername());
//		parentToUpdate.setTelFixe(parent.getTelFixe());
//		parentToUpdate.setTelMobile(parent.getTelMobile());
//		parentToUpdate.setTelPro(parent.getTelPro());


        ParentDto parentUpdated = this.parentService.updateParent(parentToUpdate);
		return ResponseEntity.ok(parentUpdated);
	}

	/**
	 * @param id parent
	 * @return
	 * @suppression d'un parent
	 */

	@DeleteMapping("/parent/{id}")
	ResponseEntity<ParentDto> deleteParent(@PathVariable(value="id") Long id){
        ParentDto parent = this.parentService.getParent(id);
			if(parent == null)
				return ResponseEntity.notFound().build();

			this.parentService.deleteParent(parent);
			return ResponseEntity.ok().build();
		}

	}

