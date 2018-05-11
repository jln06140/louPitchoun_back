package co.simplon.controller.mapper;

import co.simplon.controller.dto.InfoEmployeDto;
import co.simplon.controller.dto.InfoEnfantDto;
import co.simplon.controller.dto.InfoParentDto;
import co.simplon.controller.dto.InfoUserDto;
import co.simplon.model.EnfantInfo;
import co.simplon.model.Info;
import co.simplon.model.UserInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface InfoMapper {

    @Mappings({
            @Mapping(target="dateEmbauche", source = "info.dateEmbauche",
                    dateFormat = "dd-MM-yyyy HH:mm:ss"),
    })
    InfoUserDto map (UserInfo info);

    @Mappings({
            @Mapping(target="dateEmbauche", source = "infoUser.dateEmbauche",
                    dateFormat = "dd-MM-yyyy HH:mm:ss"),
    })
    UserInfo map (InfoUserDto infoUser);

    @Mappings({
            @Mapping(target="dateEmbauche", source = "info.dateEmbauche",
                    dateFormat = "dd-MM-yyyy HH:mm:ss"),
    })
    InfoEmployeDto infoEmployeDtotoInfo(UserInfo info);

    @Mappings({
            @Mapping(target="dateEmbauche", source = "infoEmployeDto.dateEmbauche",
                    dateFormat = "dd-MM-yyyy HH:mm:ss"),
    })
    UserInfo infoToInfoEmployeDto(InfoEmployeDto infoEmployeDto);

    InfoParentDto infoParentDtoToInfo(UserInfo info);

    UserInfo infoToInfoParentDto(InfoParentDto infoParentDto);

    InfoEnfantDto enfantInfoToInfoEnfantDto (EnfantInfo enfantInfo);

    EnfantInfo infoEnfantDtoToEnfantInfo (InfoEnfantDto infoEnfantDto);
}
