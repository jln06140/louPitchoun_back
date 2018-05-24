package co.simplon.controller;

import co.simplon.dao.TypeActiviteDao;
import co.simplon.model.TypeActivite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/typeActivite")
public class TypeActiviteController {

    @Autowired
    private TypeActiviteDao typeActiviteDao;

    /**
     *
     * @return
     */
    @GetMapping
    List<TypeActivite> getAllTypeActivite() {
        return this.typeActiviteDao.findAll();
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("{id}")
    ResponseEntity<TypeActivite> getTypeActivite(@PathVariable(value = "id") Long id){
        TypeActivite typeActivite= this.typeActiviteDao.findOne(id);
        if( typeActivite == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(typeActivite);
    }
}
