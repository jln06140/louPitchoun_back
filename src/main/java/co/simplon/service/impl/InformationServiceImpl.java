package co.simplon.service.impl;

import java.util.List;

import co.simplon.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.dao.CommonInfoDao;

import co.simplon.service.InformationService;

@Service
public class InformationServiceImpl implements InformationService {

	@Autowired
	private CommonInfoDao commonInfoDao;
	

	
	@Override
	public UserInfo getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfo addInfo(UserInfo userInfo) {
		return this.commonInfoDao.save(userInfo);
	}

	@Override
	public UserInfo updateInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserInfo> getAllInfos() {
		return this.commonInfoDao.findAll();
	}

	/*@Override
	public ParentInfo addParentInfo(ParentInfo parentInfo) {
		return this.parentInfoDao.save(parentInfo);
	}*/

}
