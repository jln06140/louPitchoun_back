package co.simplon.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.model.Parent;

@Repository
public interface ParentDao extends JpaRepository<Parent, Long>{

}
