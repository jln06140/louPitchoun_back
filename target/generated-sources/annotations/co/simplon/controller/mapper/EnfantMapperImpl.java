package co.simplon.controller.mapper;

import co.simplon.controller.dto.EnfantDto;
import co.simplon.controller.dto.ParentDto;
import co.simplon.enums.SectionEnum;
import co.simplon.model.Enfant;
import co.simplon.model.JourneeEnfant;
import co.simplon.model.Section;
import co.simplon.model.Utilisateur;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class EnfantMapperImpl implements EnfantMapper {

    @Autowired
    private InfoMapper infoMapper;
    @Autowired
    private UtilisateurMapper utilisateurMapper;

    @Override
    public EnfantDto enfantToEnfantDto(Enfant enfant) {
        if ( enfant == null ) {
            return null;
        }

        EnfantDto enfantDto = new EnfantDto();

        SectionEnum nom = enfantSectionNom( enfant );
        if ( nom != null ) {
            enfantDto.setSection( nom );
        }
        if ( enfant.getCreatedDate() != null ) {
            enfantDto.setCreatedDate( DateTimeFormatter.ofPattern( "dd-MM-yyyy HH:mm:ss" ).format( enfant.getCreatedDate() ) );
        }
        enfantDto.setId( enfant.getId() );
        enfantDto.setEnfantInfo( infoMapper.enfantInfoToInfoEnfantDto( enfant.getEnfantInfo() ) );
        enfantDto.setGeniteurs( utilisateurMapper.mapListUtilisateurToParentDtoSansEnfant( enfant.getGeniteurs() ) );
        List<JourneeEnfant> list1 = enfant.getJournees();
        if ( list1 != null ) {
            enfantDto.setJournees( new ArrayList<JourneeEnfant>( list1 ) );
        }
        else {
            enfantDto.setJournees( null );
        }

        return enfantDto;
    }

    @Override
    public Enfant enfantDtoToEnfant(EnfantDto enfantDto) {
        if ( enfantDto == null ) {
            return null;
        }

        Enfant enfant = new Enfant();

        if ( enfantDto.getCreatedDate() != null ) {
            enfant.setCreatedDate( java.time.LocalDateTime.parse( enfantDto.getCreatedDate(), DateTimeFormatter.ofPattern( "dd-MM-yyyy HH:mm:ss" ) ) );
        }
        if ( enfantDto.getId() != null ) {
            enfant.setId( enfantDto.getId() );
        }
        enfant.setGeniteurs( parentDtoListToUtilisateurList( enfantDto.getGeniteurs() ) );
        enfant.setEnfantInfo( infoMapper.infoEnfantDtoToEnfantInfo( enfantDto.getEnfantInfo() ) );
        enfant.setSection( sectionEnumToSection( enfantDto.getSection() ) );
        List<JourneeEnfant> list1 = enfantDto.getJournees();
        if ( list1 != null ) {
            enfant.setJournees( new ArrayList<JourneeEnfant>( list1 ) );
        }
        else {
            enfant.setJournees( null );
        }

        return enfant;
    }

    @Override
    public List<EnfantDto> listEnfantToEnfantDto(List<Enfant> enfant) {
        if ( enfant == null ) {
            return null;
        }

        List<EnfantDto> list = new ArrayList<EnfantDto>( enfant.size() );
        for ( Enfant enfant1 : enfant ) {
            list.add( enfantToEnfantDto( enfant1 ) );
        }

        return list;
    }

    @Override
    public List<Enfant> listEnfantDtoToEnfant(List<EnfantDto> enfantDto) {
        if ( enfantDto == null ) {
            return null;
        }

        List<Enfant> list = new ArrayList<Enfant>( enfantDto.size() );
        for ( EnfantDto enfantDto1 : enfantDto ) {
            list.add( enfantDtoToEnfant( enfantDto1 ) );
        }

        return list;
    }

    private SectionEnum enfantSectionNom(Enfant enfant) {
        if ( enfant == null ) {
            return null;
        }
        Section section = enfant.getSection();
        if ( section == null ) {
            return null;
        }
        SectionEnum nom = section.getNom();
        if ( nom == null ) {
            return null;
        }
        return nom;
    }

    protected List<Utilisateur> parentDtoListToUtilisateurList(List<ParentDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Utilisateur> list1 = new ArrayList<Utilisateur>( list.size() );
        for ( ParentDto parentDto : list ) {
            list1.add( utilisateurMapper.ParentDtoToUtilisateur( parentDto ) );
        }

        return list1;
    }

    protected Section sectionEnumToSection(SectionEnum sectionEnum) {
        if ( sectionEnum == null ) {
            return null;
        }

        Section section = new Section();

        return section;
    }
}
