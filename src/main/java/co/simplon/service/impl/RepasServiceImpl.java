package co.simplon.service.impl;

import co.simplon.dao.RepasDao;
import co.simplon.model.Enfant;
import co.simplon.model.JourneeEnfant;
import co.simplon.model.Repas;
import co.simplon.service.JourneeEnfantService;
import co.simplon.service.RepasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RepasServiceImpl implements RepasService {

    @Autowired
    private RepasDao repasDao;

    @Autowired
    private JourneeEnfantService journeeEnfantService;

    @Override
    public Repas getRepas(Long id) {
        return this.repasDao.findOne(id);
    }

    @Override
    public List<Repas> getAllRepas() {
        return this.repasDao.findAll();
    }

    @Override
    public Repas addRepas(Repas repas, Long journeeId) {
        JourneeEnfant journeeEnfant = this.journeeEnfantService.getJournee(journeeId);
        //erreur si journee n'existe pas
        journeeEnfant.getRepas().add(repas);
        return this.repasDao.save(repas);

    }

    @Override
    public void DeleteRepas(Repas repas) {
        this.repasDao.delete(repas);
    }

    @Override
    public Repas updateRepas(Repas repas) {
        return this.repasDao.save(repas);
    }

    @Override
    public List<Repas> getAllRepasByEnfant(Long enfantId) {
        List<JourneeEnfant> journeesEnfant = this.journeeEnfantService.getJourneesByEnfant(enfantId);
        List<Repas> allRepasEnfant = new ArrayList<>();
        for(JourneeEnfant journeeEnfant : journeesEnfant){
            allRepasEnfant.addAll(journeeEnfant.getRepas());
        }
        return allRepasEnfant;
    }

    @Override
    public List<Repas> getAllRepasByJourneeEnfant(Long JourneeEnfantId) {
        JourneeEnfant journeeEnfant = this.journeeEnfantService.getJourneeEnCoursEnfant(JourneeEnfantId);
        return journeeEnfant.getRepas();
    }
}
