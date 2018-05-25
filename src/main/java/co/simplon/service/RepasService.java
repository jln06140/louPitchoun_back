package co.simplon.service;

import co.simplon.model.Repas;

import java.util.List;

public interface RepasService {

    Repas getRepas(Long id);
    List<Repas> getAllRepas();
    Repas addRepas(Repas repas, Long journeeId);
    void DeleteRepas(Repas repas);
    Repas updateRepas(Repas repas);
    List<Repas> getAllRepasByEnfant(Long enfantId);
    List<Repas> getAllRepasByJourneeEnfant(Long JourneeEnfantId);
}
