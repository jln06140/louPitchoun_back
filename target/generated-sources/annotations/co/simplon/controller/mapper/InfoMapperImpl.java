package co.simplon.controller.mapper;

import co.simplon.controller.dto.InfoEmployeDto;
import co.simplon.controller.dto.InfoEnfantDto;
import co.simplon.controller.dto.InfoParentDto;
import co.simplon.controller.dto.InfoUserDto;
import co.simplon.model.EnfantInfo;
import co.simplon.model.UserInfo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class InfoMapperImpl implements InfoMapper {

    @Override
    public InfoUserDto map(UserInfo info) {
        if ( info == null ) {
            return null;
        }

        InfoUserDto infoUserDto = new InfoUserDto();

        infoUserDto.setDateEmbauche( info.getDateEmbauche() );
        infoUserDto.setId( info.getId() );
        infoUserDto.setNom( info.getNom() );
        infoUserDto.setPrenom( info.getPrenom() );
        infoUserDto.setAdresse( info.getAdresse() );
        infoUserDto.setEmail( info.getEmail() );
        infoUserDto.setTelMobile( info.getTelMobile() );
        infoUserDto.setTelPro( info.getTelPro() );
        infoUserDto.setTelFixe( info.getTelFixe() );
        infoUserDto.setFonction( info.getFonction() );
        infoUserDto.setTypeContrat( info.getTypeContrat() );
        infoUserDto.setMatricule( info.getMatricule() );
        infoUserDto.setVille( info.getVille() );

        return infoUserDto;
    }

    @Override
    public UserInfo map(InfoUserDto infoUser) {
        if ( infoUser == null ) {
            return null;
        }

        UserInfo userInfo = new UserInfo();

        userInfo.setDateEmbauche( infoUser.getDateEmbauche() );
        if ( infoUser.getId() != null ) {
            userInfo.setId( infoUser.getId() );
        }
        userInfo.setNom( infoUser.getNom() );
        userInfo.setPrenom( infoUser.getPrenom() );
        userInfo.setAdresse( infoUser.getAdresse() );
        userInfo.setVille( infoUser.getVille() );
        userInfo.setEmail( infoUser.getEmail() );
        userInfo.setTelMobile( infoUser.getTelMobile() );
        userInfo.setTelPro( infoUser.getTelPro() );
        userInfo.setTelFixe( infoUser.getTelFixe() );
        userInfo.setFonction( infoUser.getFonction() );
        userInfo.setTypeContrat( infoUser.getTypeContrat() );
        userInfo.setMatricule( infoUser.getMatricule() );

        return userInfo;
    }

    @Override
    public InfoEmployeDto infoEmployeDtotoInfo(UserInfo info) {
        if ( info == null ) {
            return null;
        }

        InfoEmployeDto infoEmployeDto = new InfoEmployeDto();

        if ( info.getDateEmbauche() != null ) {
            infoEmployeDto.setDateEmbauche( new SimpleDateFormat( "dd-MM-yyyy HH:mm:ss" ).format( info.getDateEmbauche() ) );
        }
        infoEmployeDto.setId( info.getId() );
        infoEmployeDto.setEmail( info.getEmail() );
        infoEmployeDto.setFonction( info.getFonction() );
        infoEmployeDto.setTypeContrat( info.getTypeContrat() );
        infoEmployeDto.setMatricule( info.getMatricule() );
        infoEmployeDto.setNom( info.getNom() );
        infoEmployeDto.setPrenom( info.getPrenom() );
        infoEmployeDto.setTelMobile( info.getTelMobile() );

        return infoEmployeDto;
    }

    @Override
    public UserInfo infoToInfoEmployeDto(InfoEmployeDto infoEmployeDto) {
        if ( infoEmployeDto == null ) {
            return null;
        }

        UserInfo userInfo = new UserInfo();

        try {
            if ( infoEmployeDto.getDateEmbauche() != null ) {
                userInfo.setDateEmbauche( new SimpleDateFormat( "dd-MM-yyyy HH:mm:ss" ).parse( infoEmployeDto.getDateEmbauche() ) );
            }
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }
        if ( infoEmployeDto.getId() != null ) {
            userInfo.setId( infoEmployeDto.getId() );
        }
        userInfo.setNom( infoEmployeDto.getNom() );
        userInfo.setPrenom( infoEmployeDto.getPrenom() );
        userInfo.setEmail( infoEmployeDto.getEmail() );
        userInfo.setTelMobile( infoEmployeDto.getTelMobile() );
        userInfo.setFonction( infoEmployeDto.getFonction() );
        userInfo.setTypeContrat( infoEmployeDto.getTypeContrat() );
        userInfo.setMatricule( infoEmployeDto.getMatricule() );

        return userInfo;
    }

    @Override
    public InfoParentDto infoParentDtoToInfo(UserInfo info) {
        if ( info == null ) {
            return null;
        }

        InfoParentDto infoParentDto = new InfoParentDto();

        infoParentDto.setId( info.getId() );
        infoParentDto.setAdresse( info.getAdresse() );
        infoParentDto.setVille( info.getVille() );
        infoParentDto.setEmail( info.getEmail() );
        infoParentDto.setTelMobile( info.getTelMobile() );
        infoParentDto.setTelPro( info.getTelPro() );
        infoParentDto.setTelFixe( info.getTelFixe() );
        infoParentDto.setNom( info.getNom() );
        infoParentDto.setPrenom( info.getPrenom() );

        return infoParentDto;
    }

    @Override
    public UserInfo infoToInfoParentDto(InfoParentDto infoParentDto) {
        if ( infoParentDto == null ) {
            return null;
        }

        UserInfo userInfo = new UserInfo();

        if ( infoParentDto.getId() != null ) {
            userInfo.setId( infoParentDto.getId() );
        }
        userInfo.setNom( infoParentDto.getNom() );
        userInfo.setPrenom( infoParentDto.getPrenom() );
        userInfo.setAdresse( infoParentDto.getAdresse() );
        userInfo.setVille( infoParentDto.getVille() );
        userInfo.setEmail( infoParentDto.getEmail() );
        userInfo.setTelMobile( infoParentDto.getTelMobile() );
        userInfo.setTelPro( infoParentDto.getTelPro() );
        userInfo.setTelFixe( infoParentDto.getTelFixe() );

        return userInfo;
    }

    @Override
    public InfoEnfantDto enfantInfoToInfoEnfantDto(EnfantInfo enfantInfo) {
        if ( enfantInfo == null ) {
            return null;
        }

        InfoEnfantDto infoEnfantDto = new InfoEnfantDto();

        infoEnfantDto.setId( enfantInfo.getId() );
        if ( enfantInfo.getAllergie() != null ) {
            infoEnfantDto.setAllergie( Boolean.parseBoolean( enfantInfo.getAllergie() ) );
        }
        if ( enfantInfo.getMaladie() != null ) {
            infoEnfantDto.setMaladie( Boolean.parseBoolean( enfantInfo.getMaladie() ) );
        }
        infoEnfantDto.setBiberon( enfantInfo.isBiberon() );

        return infoEnfantDto;
    }

    @Override
    public EnfantInfo infoEnfantDtoToEnfantInfo(InfoEnfantDto infoEnfantDto) {
        if ( infoEnfantDto == null ) {
            return null;
        }

        EnfantInfo enfantInfo = new EnfantInfo();

        if ( infoEnfantDto.getId() != null ) {
            enfantInfo.setId( infoEnfantDto.getId() );
        }
        enfantInfo.setAllergie( String.valueOf( infoEnfantDto.isAllergie() ) );
        enfantInfo.setMaladie( String.valueOf( infoEnfantDto.isMaladie() ) );
        enfantInfo.setBiberon( infoEnfantDto.isBiberon() );

        return enfantInfo;
    }
}
