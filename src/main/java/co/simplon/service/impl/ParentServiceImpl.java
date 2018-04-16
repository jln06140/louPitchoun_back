package co.simplon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.dao.ParentDao;
import co.simplon.model.Employe;
import co.simplon.model.Parent;
import co.simplon.service.ParentService;

@Service
public class ParentServiceImpl implements ParentService{

	@Autowired
	private ParentDao parentDao;

	@Override
	public List<Parent> getAllParent() {
		return this.parentDao.findAll();
	}

	@Override
	public Parent addParent(Parent parent) {
		return this.parentDao.save(parent);
	}

	@Override
	public Parent getParent(Long id) {
		return this.parentDao.findOne(id);
	}

	@Override
	public Parent updateParent(Parent parent) {
		return this.parentDao.save(parent);
	}

	@Override
	public void deleteParent(Parent parent) {
		this.parentDao.delete(parent);
		
	}

		  
}
