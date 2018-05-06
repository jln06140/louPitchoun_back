//package co.simplon.controller;
//
//import java.util.List;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import co.simplon.model.old.EmployeOld;
//import co.simplon.model.old.ParentOld;
//import co.simplon.model.old.UtilisateurOld;
//import co.simplon.service.EmployeService;
//import co.simplon.service.ParentService;
//
//@RestController
//@CrossOrigin
//@RequestMapping("/api")
//public class ParentController extends UtilisateurOld {
//
//	@Autowired
//	private ParentService parentService;
//	
//	
//	/*
//	 * @return
//	 * Retourne tous les parents
//	 */
//	
//	@GetMapping("/parent")
//	List<ParentOld> getAllParent(){
//		return this.parentService.getAllParent();
//	}
//	
//	/*
//	 *@param id du parent
//	 *@return
//	 *retourne un parent
//	 */
//	
//	@GetMapping("/parent/{id}")
//	ResponseEntity<ParentOld> getEmployeById (@PathVariable(value="id") long id){
//		ParentOld parent = this.parentService.getParent(id);
//		if( parent == null )
//			return ResponseEntity.notFound().build();
//		return ResponseEntity.ok().body(parent);
//	}
//	
//	/**
//	 * @param parent
//	 * @return
//	 * creation et ajout d'un nouveau parent
//	 */
//	
//	@PostMapping("/parent")
//	ParentOld addParent(@Valid @RequestBody ParentOld parent) {
//		return this.parentService.addParent(parent);
//	}
//	
//	/**
//	 * @param id parent
//	 * @param parent
//	 * @return
//	 * mise a jour d'un parent
//	 */
//	
//	@PutMapping("/parent/{id}")
//	ResponseEntity<ParentOld> updateParent(@PathVariable(value = "id") Long id,@Valid @RequestBody ParentOld parent){
//		ParentOld parentToUpdate = this.parentService.getParent(id);
//		if (parentToUpdate == null)
//			return ResponseEntity.notFound().build();
//		
//		parentToUpdate.setNom(parent.getNom());
//		parentToUpdate.setPrenom(parent.getPrenom());
//		parentToUpdate.setDateDeNaissance(parent.getDateDeNaissance());
//		parentToUpdate.setAdresse(parent.getAdresse());
//		parentToUpdate.setAdressePro(parent.getAdressePro());
//		parentToUpdate.setEmail(parent.getUsername());
//		parentToUpdate.setTelFixe(parent.getTelFixe());
//		parentToUpdate.setTelMobile(parent.getTelMobile());
//		parentToUpdate.setTelPro(parent.getTelPro());
//		
//		
//		ParentOld parentUpdated = this.parentService.updateParent(parentToUpdate);
//		return ResponseEntity.ok(parentUpdated);
//	}
//	
//	/**
//	 * @param id parent
//	 * @return
//	 * @suppression d'un parent
//	 */
//	
//	@DeleteMapping("/parent/{id}")
//	ResponseEntity<ParentOld> deleteParent(@PathVariable(value="id") Long id){
//			ParentOld parent = this.parentService.getParent(id);
//			if(parent == null)
//				return ResponseEntity.notFound().build();
//			
//			this.parentService.deleteParent(parent);
//			return ResponseEntity.ok().build();
//		}
//		
//	}
//
