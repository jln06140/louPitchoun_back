package co.simplon.dao;

import co.simplon.model.Sieste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiesteDao extends JpaRepository<Sieste, Long>{
}
