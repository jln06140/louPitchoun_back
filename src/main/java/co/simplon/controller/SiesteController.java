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

    @GetMapping("/demarrerSieste/{id}")
    ResponseEntity<Sieste> demarrerSieste (@PathVariable(value = "id") Long enfantId) throws Exception {

        Sieste siesteEnCours = this.siesteService.debuterSieste(enfantId);
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

    @GetMapping("/siestesEnCours")
    List<Sieste> getAllSiestesEnCours(){
        List<Sieste> siestesEnCours = this.siesteService.allSiesteEnCours();
        return siestesEnCours;
    }

    @GetMapping("/siestesEnCoursParEnfant/{id}")
    ResponseEntity<Sieste> SiestesEnCoursParEnfant(@PathVariable(value = "id") Long enfantId) throws Exception {
        try{
            Sieste siesteEnCoursEnfant =  this.siesteService.getSiesteEnCoursEnfant(enfantId);
            return ResponseEntity.ok().body(siesteEnCoursEnfant);
        }catch (Exception e){
            ResponseEntity.badRequest().build();
        }

        return null;
    }




}
