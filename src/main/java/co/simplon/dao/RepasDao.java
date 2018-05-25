package co.simplon.dao;

import co.simplon.model.Repas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepasDao extends JpaRepository<Repas, Long> {
}
