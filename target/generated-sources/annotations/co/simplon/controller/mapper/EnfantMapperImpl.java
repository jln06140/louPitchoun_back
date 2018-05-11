package co.simplon.controller.mapper;

import co.simplon.controller.dto.EnfantDto;
import co.simplon.controller.dto.ParentDto;
import co.simplon.model.Enfant;
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

        if ( enfant.getCreatedDate() != null ) {
            enfantDto.setCreatedDate( DateTimeFormatter.ofPattern( "dd-MM-yyyy HH:mm:ss" ).format( enfant.getCreatedDate() ) );
        }
        enfantDto.setId( enfant.getId() );
        enfantDto.setEnfantInfo( infoMapper.enfantInfoToInfoEnfantDto( enfant.getEnfantInfo() ) );
        enfantDto.setGeniteurs( utilisateurMapper.mapListUtilisateurToParentDto( enfant.getGeniteurs() ) );

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
}
