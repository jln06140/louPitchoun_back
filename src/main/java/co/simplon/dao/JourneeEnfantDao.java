package co.simplon.dao;

import co.simplon.model.JourneeEnfant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JourneeEnfantDao extends JpaRepository<JourneeEnfant, Long> {
    //JourneeEnfant findByDateAndEnfant();
}
