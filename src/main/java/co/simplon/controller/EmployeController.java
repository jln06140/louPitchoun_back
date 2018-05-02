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
//import co.simplon.service.EmployeService;
//
//@RestController
//@CrossOrigin
//@RequestMapping("/api")
//public class EmployeController {
//
//	@Autowired
//	private EmployeService serviceEmploye;
//	
//	
//	/*
//	 * @return
//	 * Retourne tous les employes
//	 */
//	
//	@GetMapping("/employe")
//	List<Employe> getAllEmploye(){
//		return this.serviceEmploye.getAllEmploye();
//	}
//	
//	/*
//	 *@param id de l'employe
//	 *@return
//	 *retourne un employe
//	 */
//	
//	@GetMapping("/employe/{id}")
//	ResponseEntity<Employe> getEmployeById (@PathVariable(value="id") long id){
//		Employe employe = this.serviceEmploye.getEmploye(id);
//		if( employe == null )
//			return ResponseEntity.notFound().build();
//		return ResponseEntity.ok().body(employe);
//	}
//	
//	/**
//	 * @param employe
//	 * @return
//	 * creation et ajout d'un nouvel employe
//	 */
//	
//	@PostMapping("/employe")
//	Employe addEmploye(@Valid @RequestBody Employe employe) {
//		return this.serviceEmploye.addEmploye(employe);
//	}
//	
//	/**
//	 * @param id employe
//	 * @param employe
//	 * @return
//	 * mise a jour d'un employe
//	 */
//	
//	@PutMapping("/employe/{id}")
//	ResponseEntity<Employe> updateEmploye(@PathVariable(value = "id") Long id,@Valid @RequestBody Employe employe){
//		Employe employeToUpdate = this.serviceEmploye.getEmploye(id);
//		if (employeToUpdate == null)
//			return ResponseEntity.notFound().build();
//		
//		employeToUpdate.setNom(employe.getNom());
//		employeToUpdate.setPrenom(employe.getPrenom());
//		employeToUpdate.setTypeContrat(employe.getTypeContrat());
//		employeToUpdate.setDateDeNaissance(employe.getDateDeNaissance());
//		employeToUpdate.setGrade(employe.getGrade());
//		employeToUpdate.setFonction(employe.getFonction());
//		
//		Employe employeUpdated = this.serviceEmploye.updateEmploye(employeToUpdate);
//		return ResponseEntity.ok(employeUpdated);
//	}
//	
//	/**
//	 * @param id employe
//	 * @return
//	 * @suppression d'un employe
//	 */
//	
//	@DeleteMapping("/employe/{id}")
//	ResponseEntity<Employe> deleteEmploye(@PathVariable(value="id") Long id){
//		Employe employe = this.serviceEmploye.getEmploye(id);
//		if(employe == null)
//			return ResponseEntity.notFound().build();
//		
//		this.serviceEmploye.deleteEmploye(employe);
//		return ResponseEntity.ok().build();
//	}
//	
//}
