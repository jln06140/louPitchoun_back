package co.simplon.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.model.Profil;
import co.simplon.model.Utilisateur;

@Repository
public interface ParentDao extends JpaRepository<Utilisateur, Long>{
	
	Set<Utilisateur> findByProfil(Profil profil);

}
