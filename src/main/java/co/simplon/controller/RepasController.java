package co.simplon.controller;

import co.simplon.model.Repas;
import co.simplon.service.RepasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/repas")
public class RepasController {

    @Autowired
    private RepasService repasService;


    /**
     * @return
     */
    @GetMapping
    List<Repas> getAllRepas() {

        return this.repasService.getAllRepas();
    }

    /**
     *
     * @param enfantId
     * @return
     */
    @GetMapping("/repasenfants/{id}")
    List<Repas> getAllRepasByEnfant(@PathVariable(value = "id") Long enfantId) {
        return this.repasService.getAllRepasByEnfant(enfantId);
    }

    /**
     *
     * @param journeeId
     * @return
     */
    @GetMapping("/repasjournee/{id}")
    List<Repas> getAllRepasJourneeEnfant(@PathVariable(value = "id") Long journeeId) {
        return this.repasService.getAllRepasByJourneeEnfant(journeeId);
    }

    /**
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    ResponseEntity<Repas> getRepas(@PathVariable(value = "id") Long id) {
        Repas repas = this.repasService.getRepas(id);
        if (repas == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(repas);
    }

    /**
     *
     * @param journeeId
     * @param repas
     * @return
     */
    @PostMapping("/ajoutrepas/{id}")
    Repas addRepasDansJournee(@PathVariable(value = "id") Long journeeId, @Valid @RequestBody Repas repas) {
        return this.repasService.addRepas(repas, journeeId);
    }

    /**
     * @param id
     * @param repas
     * @return
     */
    @PutMapping("/{id}")
    ResponseEntity<Repas> updateRepas(@PathVariable(value = "id") Long id, @Valid @RequestBody Repas repas) {
        Repas repasUpdate = this.repasService.getRepas(id);
        if (repasUpdate == null) {
            return ResponseEntity.notFound().build();
        }
        Repas repasUpdated = this.repasService.updateRepas(repas);
        return ResponseEntity.ok(repasUpdated);
    }

    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    ResponseEntity<Repas> deleteRepas(@PathVariable(value = "id") Long id) {
        Repas repas = this.repasService.getRepas(id);
        if (repas == null) {
            return ResponseEntity.notFound().build();
        }
        this.repasService.DeleteRepas(repas);
        return ResponseEntity.ok().build();
    }
}





