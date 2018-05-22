package co.simplon.controller;

import co.simplon.controller.dto.EmployeDto;
import co.simplon.model.Activite;
import co.simplon.service.ActiviteService;
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

    /**
     *
     * @param activite
     * @return
     */
    @PostMapping
    Activite addActivite (@Valid @RequestBody Activite activite){
        return this.activiteService.addActivite(activite);
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
