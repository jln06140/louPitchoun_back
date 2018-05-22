package co.simplon.dao;

import co.simplon.model.Activite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActiviteDao extends JpaRepository<Activite, Long> {
}
