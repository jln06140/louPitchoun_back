package co.simplon.controller;

import co.simplon.enums.SectionEnum;
import co.simplon.model.Section;
import co.simplon.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/section")
public class SectionController {

    @Autowired
    private SectionService sectionService;

    @GetMapping
    List<Section> getAllSection(){
        return this.sectionService.getAllSections();
    }

    @GetMapping("/petit")
    Section getSectionPetit() { return this.sectionService.getSectionByNom(SectionEnum.PETIT);}

    @GetMapping("/moyen")
    Section getSectionMoyen() { return this.sectionService.getSectionByNom(SectionEnum.MOYEN);}

    @GetMapping("/grand")
    Section getSectionGrand() { return this.sectionService.getSectionByNom(SectionEnum.GRAND);}
}
