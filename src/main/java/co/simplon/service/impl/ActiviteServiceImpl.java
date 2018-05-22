package co.simplon.service.impl;

import co.simplon.dao.ActiviteDao;
import co.simplon.model.Activite;
import co.simplon.service.ActiviteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ActiviteServiceImpl implements ActiviteService {

    @Autowired
    private ActiviteDao activiteDao;

    @Override
    public Activite addActivite(Activite activite) {

        activite.setHeureDebut(LocalDateTime.now().toLocalTime());
        activite.setTypeActivite(activite.getTypeActivite());
        return this.activiteDao.save(activite);

    }

    @Override
    public Activite updateActivite(Activite activite) {
        Activite activiteUpdate = new Activite();
        activite.setId(activite.getId());
        activite.setHeureDebut(activite.getHeureDebut());
        activite.setRemarque(activite.getRemarque());
        activite.setHeureFin(activite.getHeureFin());

        return this.activiteDao.save(activite);
    }

    @Override
    public void deleteActivite(Activite activite) {
        this.activiteDao.delete(activite);
    }

    @Override
    public List<Activite> getActivites() {
        return this.activiteDao.findAll();
    }

    @Override
    public Activite getActivite(Long id) {
        return this.activiteDao.findOne(id);
    }
}
