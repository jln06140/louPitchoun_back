package co.simplon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.dao.CommonInfoDao;
import co.simplon.model.CommonInfo;
import co.simplon.service.InformationService;

@Service
public class InformationServiceImpl implements InformationService {

	@Autowired
	private CommonInfoDao commonInfoDao;
	
	@Override
	public CommonInfo getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommonInfo addInfo(CommonInfo commonInfo) {
		return this.commonInfoDao.save(commonInfo);
	}

	@Override
	public CommonInfo updateInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommonInfo> getAllInfos() {
		return this.commonInfoDao.findAll();
	}

}
