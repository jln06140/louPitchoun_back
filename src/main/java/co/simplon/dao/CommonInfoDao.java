package co.simplon.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.model.UserInfo;

@Repository
public interface CommonInfoDao extends JpaRepository<UserInfo, Long>{

	
	
}
