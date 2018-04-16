package co.simplon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.dao.EmployeDao;
import co.simplon.model.Employe;
import co.simplon.service.EmployeService;

@Service
public class EmployeServiceImpl implements EmployeService{

	@Autowired
	private EmployeDao daoEmploye;
	
	@Override
	public List<Employe> getAllEmploye() {
		return this.daoEmploye.findAll();
	}

	@Override
	public Employe addEmploye(Employe employe) {
		return this.daoEmploye.save(employe);
	}

	@Override
	public Employe getEmploye(Long id) {
		return this.daoEmploye.findOne(id);
	}

	@Override
	public Employe updateEmploye(Employe employe) {
		return this.daoEmploye.save(employe);
	}

	@Override
	public void deleteEmploye(Employe employe) {
		this.daoEmploye.delete(employe);
		
	}

}
