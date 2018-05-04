package co.simplon.controller;

import java.util.List;

import javax.validation.Valid;

import co.simplon.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import co.simplon.service.InformationService;

@RestController
@RequestMapping("/information")
@CrossOrigin
public class InformationController {
	
	@Autowired
	private InformationService informationService;
	
	@GetMapping
	List<UserInfo> getAllInfos(){
		return this.informationService.getAllInfos();
	}
	
	@PostMapping
    UserInfo addInfo(@Valid @RequestBody UserInfo userInfo) {
		return this.informationService.addInfo(userInfo);
		
	}
	
	/*@PostMapping("/information/parent")
    UserInfo addInfoParent(@Valid @RequestBody ParentInfo parentInfo) {
		return this.informationService.addInfo(parentInfo);
		
	}*/

}
