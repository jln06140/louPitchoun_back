package co.simplon.controller;

import co.simplon.model.JourneeEnfant;
import co.simplon.model.Sieste;
import co.simplon.service.SiesteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import javax.validation.Valid;
import javax.xml.ws.Response;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("sieste")
public class SiesteController {

    @Autowired
    private SiesteService siesteService;

    @GetMapping
    List<Sieste> getAllSiestes(){
        return this.siesteService.allSiestes();
    }

    @GetMapping("/{id}")
    ResponseEntity<Sieste> getSieste (@PathVariable(value="id") Long id){
        Sieste sieste = this.siesteService.getSieste(id);
        if(sieste == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(sieste);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Sieste> deleteSieste (@PathVariable (value = "id") Long id){
        Sieste sieste = this.siesteService.getSieste(id);
        if(sieste == null){
            return ResponseEntity.notFound().build();
        }
        this.siesteService.deleteSieste(sieste);
        return ResponseEntity.ok().build();
    }

    @PostMapping("ajoutsieste/{id}")
    ResponseEntity<Sieste> ajoutSieste (@PathVariable(value = "id") Long journeeId, @Valid @RequestBody Sieste sieste) throws Exception {
        //JourneeEnfant journeeEnfant = this
        Sieste siesteEnCours = this.siesteService.ajouterSieste(journeeId, sieste);
        return ResponseEntity.ok().body(siesteEnCours);
    }

    @GetMapping("/siestesEnfant/{id}")
    List<Sieste> getSiestesDuJourParEnfant(@PathVariable(value = "id") Long id){
        try{
            return this.siesteService.allSiestesDuJourParEnfant(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
