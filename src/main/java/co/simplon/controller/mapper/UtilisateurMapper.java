package co.simplon.controller.mapper;

import co.simplon.controller.dto.ParentDto;
import co.simplon.controller.dto.UserDto;
import co.simplon.controller.dto.UtilisateurDto;
import co.simplon.model.Utilisateur;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper
public interface UtilisateurMapper {

    ParentDto mapParent(Utilisateur user);

    Utilisateur map(ParentDto user);

    @Mappings({
        @Mapping(target = "profil", source = "profil.libelle")
    })
    UtilisateurDto map(Utilisateur utilisateur);

    List<UtilisateurDto> map(List<Utilisateur> utilisateur);
}
