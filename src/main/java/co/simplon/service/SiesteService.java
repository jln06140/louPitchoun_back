package co.simplon.service;


import co.simplon.model.Sieste;

import java.util.List;

public interface SiesteService {

    List<Sieste> allSiestes();
    List<Sieste> allSiestesDuJourParEnfant(Long id) throws Exception;
    List<Sieste> allSiesteEnCours();
    Sieste getSiesteEnCoursEnfant( Long enfantId) throws Exception;
    Sieste debuterSieste(Long enfantId) throws Exception;
    Sieste terminerSieste(Long enfantId);
    Sieste getSieste(Long id);
    void deleteSieste(Sieste sietse);
    Sieste updateSieste(Long id);
}
