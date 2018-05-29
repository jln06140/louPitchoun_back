package co.simplon.controller.mapper;


import co.simplon.controller.dto.EmployeDto;
import co.simplon.controller.dto.InfoEmployeDto;
import co.simplon.controller.dto.ParentDto;
import co.simplon.controller.dto.UtilisateurDto;
import co.simplon.model.Utilisateur;
import org.mapstruct.*;

import java.util.List;
import java.util.Set;

@Mapper(uses= {InfoMapper.class, EnfantMapper.class})
public interface UtilisateurMapper {

    @Mappings({
            @Mapping(target = "profil", source = "profil.libelle"),
            @Mapping(target = "infoParent", source= "user.info"),
            @Mapping(target="createdDate", source = "user.createdDate",
                    dateFormat = "dd-MM-yyyy HH:mm:ss"),
            @Mapping(target="updatedDate", source = "user.updatedDate",
                    dateFormat = "dd-MM-yyyy HH:mm:ss")
    })
    ParentDto utilisateurToParentDto(Utilisateur user);

    @Named("parentDtoSansEnfants")
    @Mappings({
            @Mapping(target = "profil", source = "profil.libelle"),
            @Mapping(target = "infoParent", source= "utilisateur.info"),
            @Mapping(target = "enfants", ignore = true),
            @Mapping(target="createdDate", source = "utilisateur.createdDate",
                    dateFormat = "dd-MM-yyyy HH:mm:ss"),
            @Mapping(target="updatedDate", source = "utilisateur.updatedDate",
                    dateFormat = "dd-MM-yyyy HH:mm:ss")
    })
    ParentDto UtilisateurToParentDtoSansEnfants (Utilisateur utilisateur);

    @Mappings({
            @Mapping(target = "info", source= "parent.infoParent"),
            @Mapping(target="createdDate", source = "parent.createdDate",
                    dateFormat = "dd-MM-yyyy HH:mm:ss"),
            @Mapping(target="updatedDate", source = "parent.updatedDate",
                    dateFormat = "dd-MM-yyyy HH:mm:ss")
    })
    Utilisateur ParentDtoToUtilisateur(ParentDto parent);

    @Mappings({
            @Mapping(target = "info", source= "employe.infoEmploye"),
            @Mapping(target="createdDate", source = "employe.createdDate",
                    dateFormat = "dd-MM-yyyy HH:mm:ss"),
            @Mapping(target="updatedDate", source = "employe.updatedDate",
                    dateFormat = "dd-MM-yyyy HH:mm:ss")
    })
    Utilisateur mapEmploye(EmployeDto employe);

    @Mappings({
            @Mapping(target = "infoEmploye", source= "utilisateur.info"),
            @Mapping(target = "section", source = "section.nom"),
            @Mapping(target = "profil", source = "profil.libelle"),
            @Mapping(target="createdDate", source = "utilisateur.createdDate",
                    dateFormat = "dd-MM-yyyy HH:mm:ss"),
            @Mapping(target="updatedDate", source = "utilisateur.updatedDate",
                    dateFormat = "dd-MM-yyyy HH:mm:ss")
    })
    EmployeDto mapEmploye(Utilisateur utilisateur);

    @Mappings({
        @Mapping(target = "infoUserDto", source= "utilisateur.info"),
        @Mapping(target = "profil", source = "profil.libelle"),
            @Mapping(target = "section", source = "section.nom"),
        @Mapping(target="createdDate", source = "utilisateur.createdDate",
                dateFormat = "dd-MM-yyyy HH:mm:ss"),
        @Mapping(target="updatedDate", source = "utilisateur.updatedDate",
                dateFormat = "dd-MM-yyyy HH:mm:ss")
    })
    UtilisateurDto map(Utilisateur utilisateur);

    @Mappings({
            @Mapping(target = "info", source= "utilisateur.infoUserDto"),
            @Mapping(target="createdDate", source = "utilisateur.createdDate",
                    dateFormat = "dd-MM-yyyy HH:mm:ss"),
            @Mapping(target="updatedDate", source = "utilisateur.updatedDate",
                    dateFormat = "dd-MM-yyyy HH:mm:ss")
    })
    Utilisateur map(UtilisateurDto utilisateur);


    List<UtilisateurDto> map(List<Utilisateur> utilisateurs);

    //List<ParentDto> mapListUtilisateurToParentDto(List<Utilisateur> utilisateurs);

    @Named("listParentSansEnfants")
    @IterableMapping(qualifiedByName = "parentDtoSansEnfants")
    List<ParentDto> mapListUtilisateurToParentDtoSansEnfant(List<Utilisateur> utilisateurs);

    List<ParentDto> mapListUtilisateurToParentDto(Set<Utilisateur> utilisateurs);

    List<EmployeDto> mapListUtilisateurToEmployDto(Set<Utilisateur> utilisateurs);
}
