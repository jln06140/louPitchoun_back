package co.simplon.service.impl;

import co.simplon.controller.dto.EnfantDto;
import co.simplon.controller.dto.ParentDto;
import co.simplon.controller.mapper.EnfantMapper;
import co.simplon.dao.EnfantDao;
import co.simplon.model.Enfant;
import co.simplon.service.EnfantService;
import co.simplon.service.ParentService;
import co.simplon.service.SectionService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

/**
 * Service liés aux enfants de la creche
 */

@Service
public class EnfantServiceImpl implements EnfantService{

    private static final Logger logger = LogManager.getLogger(UtilisateurServiceImpl.class);

    @Autowired
    private EnfantDao enfantDao;

    @Autowired
    private SectionService sectionService;

    @Autowired
    private EnfantMapper enfantMapper;


    @Override
    public EnfantDto addEnfant(EnfantDto enfant) {
        Enfant enfantToCreate = this.enfantMapper.enfantDtoToEnfant(enfant);
        enfantToCreate.setSection(this.sectionService.getSectionByNom(enfant.getSection()));
       // enfantToCreate.setSection(enfant.get);
        //Section section = t
        enfantToCreate.setCreatedDate(LocalDateTime.now());
        logger.info("enfant crée le "+ LocalDateTime.now());
        return this.enfantMapper.enfantToEnfantDto(this.enfantDao.save(enfantToCreate));
        //return this.enfantMapper.enfantToEnfantDto(this.enfantDao.save(enfantToUpdate));
    }

    @Override
    public List<EnfantDto> getEnfants() {
        return this.enfantMapper.listEnfantToEnfantDto(this.enfantDao.findAll());
    }

    @Override
    public EnfantDto getEnfant(Long id) {
        return this.enfantMapper.enfantToEnfantDto(this.enfantDao.findOne(id));
    }

    @Override
    public EnfantDto updateEnfant(EnfantDto enfantDto) {
        Enfant enfant = this.enfantMapper.enfantDtoToEnfant(getEnfant(enfantDto.getId()));
        logger.info("Mise a jour de l'enfant : "+ enfantDto.getEnfantInfo().toString());
        Enfant enfantToUpdate = this.enfantMapper.enfantDtoToEnfant(enfantDto);
        enfantToUpdate.getEnfantInfo().setId(enfant.getEnfantInfo().getId());
        enfantToUpdate.setSection(this.sectionService.getSectionByNom(enfantDto.getSection()));

        //
        if (enfantToUpdate.getEnfantInfo().getDateDeNaissance() == null){
            enfantToUpdate.getEnfantInfo().setDateDeNaissance(enfant.getEnfantInfo().getDateDeNaissance());
        }

        return this.enfantMapper.enfantToEnfantDto(this.enfantDao.save(enfantToUpdate));
    }

    @Override
    public void deleteEnfant(EnfantDto enfantDto) {
        this.enfantDao.delete(this.enfantMapper.enfantDtoToEnfant(enfantDto));

    }

//    @Override
//    public boolean aJourneeEnCours(Enfant enfant){
//        if (!enfant.getJournees().isEmpty()){
//            return enfant.getJournees().stream().filter(journee -> journee.isJourneeEnCours()).findAny();
//        }
//    }
}
