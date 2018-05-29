
package co.simplon.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;
import javax.xml.ws.Response;

import co.simplon.controller.dto.EmployeDto;
import co.simplon.exception.MotDePasseException;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
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
    List<EmployeDto> getAllEmploye() {
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
    ResponseEntity<Object> addEmploye(@Valid @RequestBody EmployeDto employe) {
        EmployeDto employeReturn = new EmployeDto();
        Map<String,String> resultMap = new HashMap<>();
        try{
            employeReturn = this.serviceEmploye.addEmploye(employe);
            return ResponseEntity.ok().body(employeReturn);
        } catch (Exception e) {
            resultMap.put("erreur","Employe deja enregistré avec ce matricule");
            return ResponseEntity.badRequest().body(resultMap);
        }

    }

    /**
     * @param id      employe
     * @param employe
     * @return mise a jour d'un employe
     */

    @PutMapping("{id}")
    ResponseEntity<Object> updateEmploye(@PathVariable(value = "id") Long id, @Valid @RequestBody EmployeDto employe) {
        EmployeDto employeToUpdate = this.serviceEmploye.getEmploye(id);
        if (employeToUpdate == null)
            return ResponseEntity.notFound().build();
    try {
        EmployeDto employeUpdated = this.serviceEmploye.updateEmploye(employe);
        return ResponseEntity.ok(employeUpdated);
    }catch(Exception e){
        Map<String,String> resultMap = new HashMap<String,String>();
        resultMap.put("message","Matricule deja utilisé");
        return ResponseEntity.badRequest().body(resultMap);
    }
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
