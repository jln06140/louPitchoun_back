package co.simplon.controller;

import co.simplon.controller.dto.EnfantDto;
import co.simplon.model.JourneeEnfant;
import co.simplon.service.JourneeEnfantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/journee")
public class JourneeEnfantController {

    @Autowired
    private JourneeEnfantService journeeEnfantService;

    @GetMapping
    List<JourneeEnfant> getAllJournees(){
        return this.journeeEnfantService.getJourneesAllEnfants();
    }

    @GetMapping("journeesEnfant/{id}")
    List<JourneeEnfant> getAllJourneesEnfant(@PathVariable(value = "id") Long id)
    {
        return this.journeeEnfantService.getJourneesByEnfant(id);
    }

    @GetMapping("journeesEnCoursEnfant/{id}")
    JourneeEnfant getJourneesEnCoursEnfant(@PathVariable(value = "id") Long id)
    {
        JourneeEnfant journeeEnfantEnCours = this.getJourneesEnCoursEnfant(id);
        if(journeeEnfantEnCours == null){
            return null;
            //to do throw error pas de journee en cours pour cet enfant
        }
        return journeeEnfantEnCours;
    }



    //Creation d'un ibjet lorsque l'enfant arrive a la creche et mise ajour heure arrivee
    @GetMapping("/debuter/{id}")
    ResponseEntity<JourneeEnfant> debuterJournee(@PathVariable(value="id") Long enfantId){
        JourneeEnfant journeeEnfant = this.journeeEnfantService.debuterJournee(enfantId);
        return ResponseEntity.ok().body(journeeEnfant);
    }

    //cloture journée d'un enfant des qu'on renseigne son depart
    @GetMapping("/cloturer/{id}")
    ResponseEntity<JourneeEnfant> cloturerJournee(@PathVariable(value="id") Long enfantId){
        JourneeEnfant journeeEnfant = this.journeeEnfantService.cloturerJournee(enfantId);
        return ResponseEntity.ok().body(journeeEnfant);
    }

    @PutMapping("/{id}")
    ResponseEntity<JourneeEnfant> updateJourneeEnCours(@PathVariable(value = "id") Long id,@RequestBody JourneeEnfant journeeEnfant){
        JourneeEnfant journeeEnfantToUpdate = this.journeeEnfantService.getJourneeEnCoursEnfant(id);
        if (journeeEnfantToUpdate == null) {
            //logger.error("Aucune journee en cours");
            return ResponseEntity.notFound().build();
        }
        JourneeEnfant journeeEnfantUpdated = this.journeeEnfantService.updateJourneeEnfant(journeeEnfant);
        return ResponseEntity.ok(journeeEnfantUpdated);
    }

}
