package co.simplon.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.model.CommonInfo;
import co.simplon.service.InformationService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class InformationController {
	
	@Autowired
	private InformationService informationService;
	
	@GetMapping("/information")
	List<CommonInfo> getAllInfos(){
		return this.informationService.getAllInfos();
	}
	
	@PostMapping("/information")
	CommonInfo addInfo(@Valid @RequestBody CommonInfo commonInfo) {
		return this.informationService.addInfo(commonInfo);
	}

}
