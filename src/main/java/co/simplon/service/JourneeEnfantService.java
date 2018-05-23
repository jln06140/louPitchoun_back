package co.simplon.service;

import co.simplon.model.Activite;
import co.simplon.model.Enfant;
import co.simplon.model.JourneeEnfant;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface JourneeEnfantService {
    List<JourneeEnfant> getJourneesEnfants();
    //JourneeEnfant addActiviteDansJournee(Activite activite, )
    List <JourneeEnfant> getJourneeEnfant(Long id);
    JourneeEnfant getJourneeByDateAndEnfant(LocalDate date);
    JourneeEnfant updateJourneeEnfant(JourneeEnfant journeeEnfant);

    JourneeEnfant debuterJournee(Long enfantId);

    JourneeEnfant cloturerJournee(Long enfantId);

    JourneeEnfant getJourneeEnCoursEnfant(Long enfantId);
}
