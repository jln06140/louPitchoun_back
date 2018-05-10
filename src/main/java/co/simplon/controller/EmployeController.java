
package co.simplon.controller;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import co.simplon.controller.dto.EmployeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.service.EmployeService;

@RestController
@CrossOrigin
@RequestMapping("/employe")
public class EmployeController {

    @Autowired
    private EmployeService serviceEmploye;

    /**
     * @return Retourne tous les employes*
     */

    @GetMapping
    Set<EmployeDto> getAllEmploye() {
        return this.serviceEmploye.getAllEmploye();
    }

    /**
     * @param id de l'employe
     * @return retourne un employe
     */

    @GetMapping("{id}")
    ResponseEntity<EmployeDto> getEmployeById(@PathVariable(value = "id") long id) {
        EmployeDto employe = this.serviceEmploye.getEmploye(id);
        if (employe == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(employe);
    }

    /**
     * @param employe
     * @return creation et ajout d'un nouvel employe
     */

    @PostMapping
    EmployeDto addEmploye(@Valid @RequestBody EmployeDto employe) {
        return this.serviceEmploye.addEmploye(employe);
    }

    /**
     * @param id      employe
     * @param employe
     * @return mise a jour d'un employe
     */

    @PutMapping("{id}")
    ResponseEntity<EmployeDto> updateEmploye(@PathVariable(value = "id") Long id, @Valid @RequestBody EmployeDto employe) {
        EmployeDto employeToUpdate = this.serviceEmploye.getEmploye(id);
        if (employeToUpdate == null)
            return ResponseEntity.notFound().build();

        EmployeDto employeUpdated = this.serviceEmploye.updateEmploye(employe);
        return ResponseEntity.ok(employeUpdated);
    }

    /**
     * @param id employe
     * @return
     * @suppression d'un employe
     */

    @DeleteMapping("{id}")
    ResponseEntity<EmployeDto> deleteEmploye(@PathVariable(value = "id") Long id) {
        EmployeDto employe = this.serviceEmploye.getEmploye(id);
        if (employe == null)
            return ResponseEntity.notFound().build();

        this.serviceEmploye.deleteEmploye(employe);
        return ResponseEntity.ok().build();
    }

}
