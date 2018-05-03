package co.simplon.service;

import java.util.List;

import co.simplon.model.CommonInfo;
import co.simplon.model.ParentInfo;

public interface InformationService {
	
	List<CommonInfo> getAllInfos();
	CommonInfo getInfo();
	CommonInfo addInfo(CommonInfo commonInfo);
	CommonInfo updateInfo();
	
	ParentInfo addParentInfo(ParentInfo parentInfo);

}
