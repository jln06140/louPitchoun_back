package co.simplon.service;

import co.simplon.controller.dto.EmployeDto;
import co.simplon.controller.dto.EnfantDto;
import co.simplon.controller.dto.ParentDto;
import co.simplon.enums.SectionEnum;
import co.simplon.model.Enfant;
import co.simplon.model.Section;

import java.util.List;

public interface SectionService {

    List<Section> getAllSections();
    Section getSection(Long id);
    Section getSectionByNom(SectionEnum sectionEnum);
    Section addSection(Section section);
    void addEnfantSection(Enfant enfant);
    Section addEmployeSection(EmployeDto employe);
    Section DeleteEnfantSection(EnfantDto enfantDto);
    Section deleteEmployeSection(EmployeDto employeDto);




}
