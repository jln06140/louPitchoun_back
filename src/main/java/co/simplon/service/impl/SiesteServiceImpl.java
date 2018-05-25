package co.simplon.service.impl;

import co.simplon.dao.SiesteDao;
import co.simplon.model.JourneeEnfant;
import co.simplon.model.Sieste;
import co.simplon.service.JourneeEnfantService;
import co.simplon.service.SiesteService;
import org.apache.tomcat.jni.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SiesteServiceImpl implements SiesteService {

    @Autowired
    private SiesteDao siesteDao;

    @Autowired
    private JourneeEnfantService journeeEnfantService;

    /**
     * Retourne toutes les siestes
     * @return
     */
    @Override
    public List<Sieste> allSiestes() {
        return this.siesteDao.findAll();
    }


    /**
     * Retourne toutes siestes du jour D'un enfant
     * @param id
     * @return
     */
    @Override
    public List<Sieste> allSiestesDuJourParEnfant(Long id) throws Exception {
        JourneeEnfant journeeEnfantEnCours = this.journeeEnfantService.getJourneeEnCoursEnfant(id);
        //if null alors pas de journee en cours pour cette enfant
        List<Sieste> siestes = journeeEnfantEnCours.getSiestes();
        if(!siestes.isEmpty()){
            return siestes;
        }else{
            throw new Exception("Aucune sieste aujourd'hui");
        }
        // if sieste empty alors pas de sieste pour cet enfant;
    }


    /**
     *
     * @param journeeId
     * @param sieste
     * @return
     * @throws Exception
     */
    @Override
    public Sieste ajouterSieste(Long journeeId, Sieste sieste) throws Exception {
        JourneeEnfant journeeEnfant = this.journeeEnfantService.getJournee(journeeId);
        journeeEnfant.getSiestes().add(sieste);
        return this.siesteDao.save(sieste);
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Sieste getSieste(Long id) {
        Sieste sieste = this.siesteDao.findOne(id);
        if (sieste != null){
            return sieste;
        }
        return null;

    }

    @Override
    public void deleteSieste(Sieste sieste) {
        this.siesteDao.delete(sieste);
    }

    @Override
    public Sieste updateSieste(Long id) {
        return null;
    }
}
