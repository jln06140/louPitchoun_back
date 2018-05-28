package co.simplon.service;

import co.simplon.model.Activite;
import co.simplon.model.Enfant;
import co.simplon.model.JourneeEnfant;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface JourneeEnfantService {
    List<JourneeEnfant> getJourneesAllEnfants();

    JourneeEnfant getJournee(Long id);

    //JourneeEnfant addActiviteDansJournee(Activite activite, )
    List <JourneeEnfant> getJourneesByEnfant(Long id);

    JourneeEnfant getJourneeByDateAndEnfant(LocalDate date, Long id);

    JourneeEnfant updateJourneeEnfant(JourneeEnfant journeeEnfant);

    JourneeEnfant debuterJournee(Long enfantId);

    JourneeEnfant cloturerJournee(Long enfantId);

    JourneeEnfant getJourneeEnCoursEnfant(Long enfantId);

    JourneeEnfant getJourneeDuJourEnfant(Long enfantId);
}
