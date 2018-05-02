package co.simplon.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.model.Utilisateur;
import java.lang.String;
import java.util.List;

@Repository
public interface UtilisateurDao extends JpaRepository<Utilisateur, Long>{
	
	Utilisateur findByLogin(String login);
}
