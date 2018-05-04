package co.simplon.service;

import java.util.List;

import co.simplon.model.UserInfo;


public interface InformationService {
	
	List<UserInfo> getAllInfos();
	UserInfo getInfo();
	UserInfo addInfo(UserInfo userInfo);
	UserInfo updateInfo();


}
