package co.simplon.service;

import co.simplon.dao.ActiviteDao;
import co.simplon.model.Activite;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface ActiviteService {

    Activite addActivite (Activite activite);
    Activite updateActivite( Activite activite);
    void deleteActivite( Activite activite);
    List<Activite> getActivites();
    Activite getActivite(Long id);

}
