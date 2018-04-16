package co.simplon.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.model.Employe;

@Repository
public interface EmployeDao extends JpaRepository<Employe, Long>{

}
