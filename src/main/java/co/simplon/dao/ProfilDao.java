package co.simplon.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.enums.ProfilEnum;
import co.simplon.model.Profil;

@Repository
public interface ProfilDao extends JpaRepository<Profil, Long>{

	List<Profil> findByLibelle(ProfilEnum libelle);


}

