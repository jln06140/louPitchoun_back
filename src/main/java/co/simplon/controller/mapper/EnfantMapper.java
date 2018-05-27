package co.simplon.controller.mapper;

import co.simplon.controller.dto.EnfantDto;
import co.simplon.model.Enfant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(uses= {InfoMapper.class, UtilisateurMapper.class})
public interface EnfantMapper {


    @Mappings({
           @Mapping(target = "section", source = "section.nom"),
            @Mapping(target = "geniteurs",qualifiedByName = {"parentDtoSansEnfants"}),
           @Mapping(target="createdDate", source = "enfant.createdDate",
                    dateFormat = "dd-MM-yyyy HH:mm:ss"),
    })
    EnfantDto enfantToEnfantDto(Enfant enfant);


    @Mappings({

            @Mapping(target="createdDate", source = "enfantDto.createdDate",
                    dateFormat = "dd-MM-yyyy HH:mm:ss"),
    })
    Enfant enfantDtoToEnfant(EnfantDto enfantDto);

    List<EnfantDto> listEnfantToEnfantDto(List<Enfant> enfant);
    List<Enfant> listEnfantDtoToEnfant (List<EnfantDto> enfantDto);
}
