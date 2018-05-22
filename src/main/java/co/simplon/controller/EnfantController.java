package co.simplon.controller;

import co.simplon.controller.dto.EnfantDto;
import co.simplon.model.Enfant;
import co.simplon.service.EnfantService;
import co.simplon.service.SectionService;
import co.simplon.service.impl.UtilisateurServiceImpl;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * controller faisant appel au service
 * EnfantService afin de modifier ou recuperer
 * les données liées a un ou plusieurs enfants
 */

@RestController
@CrossOrigin
@RequestMapping("/enfant")
public class EnfantController {

    private static final Logger logger = LogManager.getLogger(EnfantController.class);

    @Autowired
    private EnfantService enfantService;



    /**
     * @return
     * retourne une liste d'enfants
     */
    @GetMapping
    List<EnfantDto> getEnfants(){
        return this.enfantService.getEnfants();
    }

    /**
     *
     * @param id
     * @return
     * retourne un enfant
     */
    @GetMapping("/{id}")
    ResponseEntity<EnfantDto> getEnfant(@PathVariable(value="id") Long id){
        EnfantDto enfant = this.enfantService.getEnfant(id);
        if(enfant == null){
            logger.error("Enfant introuvable dans la base de donnée");
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(enfant);
    }

    /**
     *
     * @param enfantDto
     * @return
     */
    @PostMapping
    EnfantDto addEnfant(@Valid @RequestBody EnfantDto enfantDto) {
        return this.enfantService.addEnfant(enfantDto);
    }

    /**
     *
     * @param id
     * @param enfant
     * @return
     */
    @PutMapping("/{id}")
    ResponseEntity<EnfantDto> updateEnfant(@PathVariable(value = "id") Long id,@Valid @RequestBody EnfantDto enfant){
        EnfantDto enfantToUpdate = this.enfantService.getEnfant(id);
        if (enfantToUpdate == null) {
            logger.error("Enfant introuvable dans la base de donnée");
            return ResponseEntity.notFound().build();
        }
        EnfantDto enfantUpdated = this.enfantService.updateEnfant(enfant);
        return ResponseEntity.ok(enfantUpdated);
    }

    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    ResponseEntity<EnfantDto> deleteEnfant(@PathVariable(value="id") Long id){
        EnfantDto enfant = this.enfantService.getEnfant(id);
        if(enfant == null) {
            logger.error("Enfant introuvable dans la base de donnée");
            return ResponseEntity.notFound().build();
        }
        this.enfantService.deleteEnfant(enfant);
        return ResponseEntity.ok().build();
    }




}





