package co.simplon.controller;

import co.simplon.controller.dto.EmployeDto;
import co.simplon.model.Activite;
import co.simplon.model.JourneeEnfant;
import co.simplon.service.ActiviteService;
import co.simplon.service.JourneeEnfantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping("/activite")
public class ActiviteController {

    @Autowired
    private ActiviteService activiteService;

    @Autowired
    private JourneeEnfantService journeeEnfantService;

    @GetMapping
    List<Activite> getAllActivites() {
        return this.activiteService.getActivites();
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("{id}")
    ResponseEntity<Activite> getActivite(@PathVariable(value = "id") Long id){
        Activite activite = this.activiteService.getActivite(id);
        if( activite == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(activite);
    }

    @GetMapping("activitesParEnfant/{id}")
    List<Activite> getActivitesParJourneeEnCoursEnfant(@PathVariable(value = "id") Long id){
        JourneeEnfant journeeEnfant = this.journeeEnfantService.getJourneeEnCoursEnfant(id);
        if (!journeeEnfant.getActivites().isEmpty()){
            return journeeEnfant.getActivites();
        }
        return null;
        //to do throw error aucune activité dans journee en cours
    }

    /**
     *
     * @param activite
     * @return
     */
    @PostMapping("{id}")
    Activite addActiviteDansJournee (@PathVariable(value = "id") Long id,@Valid @RequestBody Activite activite){
        JourneeEnfant journeeEnfant = this.journeeEnfantService.getJournee(id);
        if(journeeEnfant != null){
            journeeEnfant.getActivites().add(activite);
            return this.activiteService.addActivite(activite);
        }
        return null;
        //to throw error impossible ajouter activite

    }

    /**
     *
     * @param id
     * @param activite
     * @return
     */
    @PutMapping("{id}")
    ResponseEntity<Activite> updateActivite(@PathVariable(value = "id") Long id, @Valid @RequestBody Activite activite) {
        Activite activiteToUpdate = this.activiteService.getActivite(id);
        if (activiteToUpdate == null)
            return ResponseEntity.notFound().build();

        Activite activiteUpdated = this.activiteService.updateActivite(activiteToUpdate);
        return ResponseEntity.ok(activiteUpdated);
    }


    @DeleteMapping("{id}")
    ResponseEntity<Activite> deleteActivite(@PathVariable(value = "id") Long id) {
        Activite activite = this.activiteService.getActivite(id);
        if (activite == null)
            return ResponseEntity.notFound().build();

        this.activiteService.deleteActivite(activite);
        return ResponseEntity.ok().build();
    }


}
