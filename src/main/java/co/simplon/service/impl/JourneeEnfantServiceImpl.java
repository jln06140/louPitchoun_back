package co.simplon.service.impl;

import co.simplon.controller.dto.EnfantDto;
import co.simplon.controller.mapper.EnfantMapper;
import co.simplon.dao.JourneeEnfantDao;
import co.simplon.model.Enfant;
import co.simplon.model.JourneeEnfant;
import co.simplon.service.EnfantService;
import co.simplon.service.JourneeEnfantService;
import co.simplon.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class JourneeEnfantServiceImpl implements JourneeEnfantService {

    @Autowired
    private JourneeEnfantDao journeeEnfantDao;

    @Autowired
    private EnfantService enfantService;

    @Autowired
    private EnfantMapper enfantMapper;

    @Autowired
    private SectionService sectionService;

    @Override
    public List<JourneeEnfant> getJourneesEnfants() {
        return this.journeeEnfantDao.findAll();
    }

    @Override
    public List <JourneeEnfant> getJourneeEnfant(Long id) {
        List<JourneeEnfant> journeesEnfants = this.getJourneesEnfants();
        List<JourneeEnfant> journeesEnfantResultat = new ArrayList<>();
        for (JourneeEnfant journeeEnfant : journeesEnfants){
            if (journeeEnfant.getEnfant().getId() == id){
                journeesEnfantResultat.add(journeeEnfant);
            }
        }
        return journeesEnfantResultat;
    }

    @Override
    public JourneeEnfant getJourneeByDateAndEnfant(LocalDate date) {
        return null;
    }

    @Override
    public JourneeEnfant updateJourneeEnfant(JourneeEnfant journeeEnfant) {
        JourneeEnfant journeeEnfantToUpodate = new JourneeEnfant();
        return null;
    }

    @Override
    public JourneeEnfant debuterJournee(Long enfantId) {
        EnfantDto enfantDto = enfantService.getEnfant(enfantId);
        Enfant enfant = this.enfantMapper.enfantDtoToEnfant(enfantDto);
        if(!enfant.isJourneeEnCours()){
//        if (getJourneeEnCoursEnfant(enfantId) != null) {
            JourneeEnfant journeeEnfant = new JourneeEnfant();
            journeeEnfant.setDate(LocalDate.now());
            journeeEnfant.setHeureArrivee(LocalDateTime.now().toLocalTime());
            journeeEnfant.setJourneeEnCours(true);
            enfant.setSection(this.sectionService.getSectionByNom(enfantDto.getSection()));
            journeeEnfant.setEnfant(enfant);
            return this.journeeEnfantDao.save(journeeEnfant);
        }
        return null;
        //to do throw error journée deja en cours
    }

    @Override
    public JourneeEnfant cloturerJournee(Long enfantId){
        JourneeEnfant journeeEnfant = this.getJourneeEnCoursEnfant(enfantId);
        if(journeeEnfant != null){
            journeeEnfant.setJourneeEnCours(false);
            journeeEnfant.setHeureDepart(LocalDateTime.now().toLocalTime());
            return this.journeeEnfantDao.save(journeeEnfant);
        }
        return null;
        // to do throw error impossible de cloturer journee car aucune journee en cours
    }

    @Override
    public JourneeEnfant getJourneeEnCoursEnfant(Long enfantId){
        EnfantDto enfantDto = this.enfantService.getEnfant(enfantId);
        if (enfantDto != null && !enfantDto.getJournees().isEmpty() ){
            List<JourneeEnfant> journeesEnfant = enfantDto.getJournees();
            JourneeEnfant journeeEnfantEnCours = journeesEnfant.stream().filter(journee -> journee.isJourneeEnCours()).findFirst().get();
            return journeeEnfantEnCours;
        }
        return null;
        //to do throw error pas de journee en cours pour cet enfant
    }


}
