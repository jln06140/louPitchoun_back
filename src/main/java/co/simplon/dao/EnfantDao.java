package co.simplon.dao;

import co.simplon.model.Enfant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnfantDao extends JpaRepository<Enfant, Long>{
}
