package co.simplon.service;

import co.simplon.model.JourneeEnfant;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface JourneeEnfantService {
    List<JourneeEnfant> getJourneesEnfants();
    List <JourneeEnfant> getJourneeEnfant(Long id);
    JourneeEnfant getJourneeByDateAndEnfant(LocalDate date);

    JourneeEnfant debuterJournee(Long enfantId);

    JourneeEnfant cloturerJournee(Long enfantId);

    JourneeEnfant getJourneeEnCoursEnfant(Long enfantId);
}
