package co.simplon.service;

import co.simplon.controller.dto.EnfantDto;
import co.simplon.controller.dto.ParentDto;
import co.simplon.dao.EnfantDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface EnfantService {

    EnfantDto addEnfant(EnfantDto enfant);
    List<EnfantDto> getEnfants();
    EnfantDto getEnfant(Long id);
    EnfantDto updateEnfant(EnfantDto enfantDto);
    void deleteEnfant(EnfantDto enfantDto);

    List<EnfantDto> getEnfantsDuParent(ParentDto parent);
}
