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
     * retourne toutes les siestes en cours
     * @return
     */
    @Override
    public List<Sieste> allSiesteEnCours() {
        List<SiesteService> allSiestesEnCours = new ArrayList<>();
        List<Sieste> siestes = this.allSiestes().stream().filter(sieste -> sieste.isSiesteEnCours()).collect(Collectors.toList());
        return siestes;
    }

    /**
     * reourne sieste en cours d'un enfant
     * @param enfantId
     * @return
     */
    @Override
    public Sieste getSiesteEnCoursEnfant(Long enfantId) throws Exception {
        Sieste siesteEnCours = allSiestesDuJourParEnfant(enfantId).stream().filter( sieste -> sieste.isSiesteEnCours()).findFirst().get();
        return siesteEnCours;
        //throw error aucune sieste en cours pour cet enfant
    }


    /**
     * Debute une sieste d'un enfant
     * @param enfantId
     * @return
     */
    @Override
    public Sieste debuterSieste(Long enfantId) throws Exception {
        List<Sieste> siestes = this.journeeEnfantService.getJourneeEnCoursEnfant(enfantId).getSiestes();
        Sieste sieste = new Sieste();
        sieste.setHeureDebut(LocalDateTime.now().toLocalTime());
        sieste.setSiesteEnCours(true);
        siestes.add(sieste);
        return this.siesteDao.save(sieste);
    }

    /**
     * Termine la sieste d'un enfant
     * @param enfantId
     * @return
     */
    @Override
    public Sieste terminerSieste(Long enfantId) {
        return null;
    }

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
