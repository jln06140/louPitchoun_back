package co.simplon.controller;

import co.simplon.model.JourneeEnfant;
import co.simplon.service.JourneeEnfantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/journee")
public class JourneeEnfantController {

    @Autowired
    private JourneeEnfantService journeeEnfantService;

    @GetMapping
    List<JourneeEnfant> getAllJournees(){
        return this.journeeEnfantService.getJourneesEnfants();
    }


    //Creation d'un ibjet lorsque l'enfant arrive a la creche et mise ajour heure arrivee
    @GetMapping("/start/{id}")
    ResponseEntity<JourneeEnfant> debuterJournee(@PathVariable(value="id") Long enfantId){
        JourneeEnfant journeeEnfant = this.journeeEnfantService.debuterJournee(enfantId);
        return ResponseEntity.ok().body(journeeEnfant);
    }

    //cloture journée d'un enfant des qu'on renseigne son depart
    @GetMapping("/close/{id}")
    ResponseEntity<JourneeEnfant> dcloturerJournee(@PathVariable(value="id") Long enfantId){
        JourneeEnfant journeeEnfant = this.journeeEnfantService.debuterJournee(enfantId);
        return ResponseEntity.ok().body(journeeEnfant);
    }

}
