package co.simplon.service.impl;

import co.simplon.controller.dto.EmployeDto;
import co.simplon.controller.dto.EnfantDto;
import co.simplon.controller.mapper.EnfantMapper;
import co.simplon.dao.SectionDao;
import co.simplon.enums.SectionEnum;
import co.simplon.model.Enfant;
import co.simplon.model.Section;
import co.simplon.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionServiceImpl implements SectionService {

    @Autowired
    private SectionDao sectionDao;

    @Autowired
    private EnfantMapper enfantMapper;

    @Override
    public List<Section> getAllSections() {
        return this.sectionDao.findAll();
    }

    @Override
    public Section getSection(Long id) {
        return this.sectionDao.findOne(id);

    }

    @Override
    public Section getSectionByNom(SectionEnum sectionEnum) {
        return this.sectionDao.findByNom(sectionEnum);
    }

    @Override
    public Section addSection(Section section) {
        return this.sectionDao.save(section);
    }

    @Override
    public void addEnfantSection(Enfant enfant) {
        Section section = enfant.getSection();
//        Enfant enfant  = this.enfantMapper.enfantDtoToEnfant(enfantDto);
        section.getEnfants().add(enfant);
        this.sectionDao.save(section);
    }

    @Override
    public Section addEmployeSection(EmployeDto employe) {
        //Section section = this.getSectionByNom(EmployeDto.getSection());
    return new Section();
    }

    @Override
    public Section DeleteEnfantSection(EnfantDto enfantDto) {
        return null;
    }

    @Override
    public Section deleteEmployeSection(EmployeDto employeDto) {
        return null;
    }
}
