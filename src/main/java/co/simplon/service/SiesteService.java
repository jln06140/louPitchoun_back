package co.simplon.service;


import co.simplon.model.Sieste;

import java.util.List;

public interface SiesteService {

    List<Sieste> allSiestes();
    List<Sieste> allSiestesDuJourParEnfant(Long id) throws Exception;

    Sieste ajouterSieste(Long journeeId, Sieste sieste) throws Exception;
    Sieste getSieste(Long id);
    void deleteSieste(Sieste sietse);
    Sieste updateSieste(Long id);
}
