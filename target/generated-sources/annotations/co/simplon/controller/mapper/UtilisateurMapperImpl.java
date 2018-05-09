package co.simplon.controller.mapper;

import co.simplon.controller.dto.EmployeDto;
import co.simplon.controller.dto.ParentDto;
import co.simplon.controller.dto.UtilisateurDto;
import co.simplon.enums.ProfilEnum;
import co.simplon.model.Enfant;
import co.simplon.model.Profil;
import co.simplon.model.Utilisateur;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class UtilisateurMapperImpl implements UtilisateurMapper {

    @Autowired
    private InfoMapper infoMapper;

    @Override
    public ParentDto utilisateurToParentDto(Utilisateur user) {
        if ( user == null ) {
            return null;
        }

        ParentDto parentDto = new ParentDto();

        parentDto.setInfoParent( infoMapper.infoParentDtoToInfo( user.getInfo() ) );
        if ( user.getCreatedDate() != null ) {
            parentDto.setCreatedDate( DateTimeFormatter.ofPattern( "dd-MM-yyyy HH:mm:ss" ).format( user.getCreatedDate() ) );
        }
        if ( user.getUpdatedDate() != null ) {
            parentDto.setUpdatedDate( DateTimeFormatter.ofPattern( "dd-MM-yyyy HH:mm:ss" ).format( user.getUpdatedDate() ) );
        }
        ProfilEnum libelle = userProfilLibelle( user );
        if ( libelle != null ) {
            parentDto.setProfil( libelle );
        }
        parentDto.setUsername( user.getUsername() );
        parentDto.setMotDePasse( user.getMotDePasse() );
        parentDto.setActif( user.isActif() );
        Set<Enfant> set = user.getEnfants();
        if ( set != null ) {
            parentDto.setEnfants( new HashSet<Enfant>( set ) );
        }
        else {
            parentDto.setEnfants( null );
        }
        parentDto.setId( user.getId() );

        return parentDto;
    }

    @Override
    public Utilisateur ParentDtoToUtilisateur(ParentDto parent) {
        if ( parent == null ) {
            return null;
        }

        Utilisateur utilisateur = new Utilisateur();

        if ( parent.getCreatedDate() != null ) {
            utilisateur.setCreatedDate( java.time.LocalDateTime.parse( parent.getCreatedDate(), DateTimeFormatter.ofPattern( "dd-MM-yyyy HH:mm:ss" ) ) );
        }
        if ( parent.getUpdatedDate() != null ) {
            utilisateur.setUpdatedDate( java.time.LocalDateTime.parse( parent.getUpdatedDate(), DateTimeFormatter.ofPattern( "dd-MM-yyyy HH:mm:ss" ) ) );
        }
        utilisateur.setInfo( infoMapper.infoToInfoParentDto( parent.getInfoParent() ) );
        utilisateur.setId( parent.getId() );
        utilisateur.setMotDePasse( parent.getMotDePasse() );
        utilisateur.setActif( parent.isActif() );
        utilisateur.setProfil( profilEnumToProfil( parent.getProfil() ) );
        Set<Enfant> set = parent.getEnfants();
        if ( set != null ) {
            utilisateur.setEnfants( new HashSet<Enfant>( set ) );
        }
        else {
            utilisateur.setEnfants( null );
        }
        utilisateur.setUsername( parent.getUsername() );

        return utilisateur;
    }

    @Override
    public Utilisateur mapEmploye(EmployeDto employe) {
        if ( employe == null ) {
            return null;
        }

        Utilisateur utilisateur = new Utilisateur();

        if ( employe.getCreatedDate() != null ) {
            utilisateur.setCreatedDate( java.time.LocalDateTime.parse( employe.getCreatedDate(), DateTimeFormatter.ofPattern( "dd-MM-yyyy HH:mm:ss" ) ) );
        }
        if ( employe.getUpdatedDate() != null ) {
            utilisateur.setUpdatedDate( java.time.LocalDateTime.parse( employe.getUpdatedDate(), DateTimeFormatter.ofPattern( "dd-MM-yyyy HH:mm:ss" ) ) );
        }
        utilisateur.setInfo( infoMapper.infoToInfoEmployeDto( employe.getInfoEmploye() ) );
        utilisateur.setMotDePasse( employe.getMotDePasse() );
        utilisateur.setActif( employe.isActif() );
        utilisateur.setProfil( profilEnumToProfil( employe.getProfil() ) );

        return utilisateur;
    }

    @Override
    public EmployeDto mapEmploye(Utilisateur utilisateur) {
        if ( utilisateur == null ) {
            return null;
        }

        EmployeDto employeDto = new EmployeDto();

        if ( utilisateur.getCreatedDate() != null ) {
            employeDto.setCreatedDate( DateTimeFormatter.ofPattern( "dd-MM-yyyy HH:mm:ss" ).format( utilisateur.getCreatedDate() ) );
        }
        if ( utilisateur.getUpdatedDate() != null ) {
            employeDto.setUpdatedDate( DateTimeFormatter.ofPattern( "dd-MM-yyyy HH:mm:ss" ).format( utilisateur.getUpdatedDate() ) );
        }
        employeDto.setInfoEmploye( infoMapper.infoEmployeDtotoInfo( utilisateur.getInfo() ) );
        ProfilEnum libelle = userProfilLibelle( utilisateur );
        if ( libelle != null ) {
            employeDto.setProfil( libelle );
        }
        employeDto.setMotDePasse( utilisateur.getMotDePasse() );
        employeDto.setActif( utilisateur.isActif() );

        return employeDto;
    }

    @Override
    public UtilisateurDto map(Utilisateur utilisateur) {
        if ( utilisateur == null ) {
            return null;
        }

        UtilisateurDto utilisateurDto = new UtilisateurDto();

        utilisateurDto.setInfoUserDto( infoMapper.map( utilisateur.getInfo() ) );
        if ( utilisateur.getCreatedDate() != null ) {
            utilisateurDto.setCreatedDate( DateTimeFormatter.ofPattern( "dd-MM-yyyy HH:mm:ss" ).format( utilisateur.getCreatedDate() ) );
        }
        if ( utilisateur.getUpdatedDate() != null ) {
            utilisateurDto.setUpdatedDate( DateTimeFormatter.ofPattern( "dd-MM-yyyy HH:mm:ss" ).format( utilisateur.getUpdatedDate() ) );
        }
        ProfilEnum libelle = userProfilLibelle( utilisateur );
        if ( libelle != null ) {
            utilisateurDto.setProfil( libelle );
        }
        utilisateurDto.setMotDePasse( utilisateur.getMotDePasse() );
        utilisateurDto.setUsername( utilisateur.getUsername() );
        utilisateurDto.setActif( utilisateur.isActif() );
        utilisateurDto.setId( utilisateur.getId() );

        return utilisateurDto;
    }

    @Override
    public Utilisateur map(UtilisateurDto utilisateur) {
        if ( utilisateur == null ) {
            return null;
        }

        Utilisateur utilisateur1 = new Utilisateur();

        if ( utilisateur.getCreatedDate() != null ) {
            utilisateur1.setCreatedDate( java.time.LocalDateTime.parse( utilisateur.getCreatedDate(), DateTimeFormatter.ofPattern( "dd-MM-yyyy HH:mm:ss" ) ) );
        }
        if ( utilisateur.getUpdatedDate() != null ) {
            utilisateur1.setUpdatedDate( java.time.LocalDateTime.parse( utilisateur.getUpdatedDate(), DateTimeFormatter.ofPattern( "dd-MM-yyyy HH:mm:ss" ) ) );
        }
        utilisateur1.setInfo( infoMapper.map( utilisateur.getInfoUserDto() ) );
        utilisateur1.setId( utilisateur.getId() );
        utilisateur1.setMotDePasse( utilisateur.getMotDePasse() );
        utilisateur1.setActif( utilisateur.isActif() );
        utilisateur1.setProfil( profilEnumToProfil( utilisateur.getProfil() ) );
        utilisateur1.setUsername( utilisateur.getUsername() );

        return utilisateur1;
    }

    @Override
    public List<UtilisateurDto> map(List<Utilisateur> utilisateurs) {
        if ( utilisateurs == null ) {
            return null;
        }

        List<UtilisateurDto> list = new ArrayList<UtilisateurDto>( utilisateurs.size() );
        for ( Utilisateur utilisateur : utilisateurs ) {
            list.add( map( utilisateur ) );
        }

        return list;
    }

    @Override
    public Set<ParentDto> mapListUtilisateurToParentDto(Set<Utilisateur> utilisateurs) {
        if ( utilisateurs == null ) {
            return null;
        }

        Set<ParentDto> set = new HashSet<ParentDto>( Math.max( (int) ( utilisateurs.size() / .75f ) + 1, 16 ) );
        for ( Utilisateur utilisateur : utilisateurs ) {
            set.add( utilisateurToParentDto( utilisateur ) );
        }

        return set;
    }

    @Override
    public Set<EmployeDto> mapListUtilisateurToEmployDto(Set<Utilisateur> utilisateurs) {
        if ( utilisateurs == null ) {
            return null;
        }

        Set<EmployeDto> set = new HashSet<EmployeDto>( Math.max( (int) ( utilisateurs.size() / .75f ) + 1, 16 ) );
        for ( Utilisateur utilisateur : utilisateurs ) {
            set.add( mapEmploye( utilisateur ) );
        }

        return set;
    }

    private ProfilEnum userProfilLibelle(Utilisateur utilisateur) {
        if ( utilisateur == null ) {
            return null;
        }
        Profil profil = utilisateur.getProfil();
        if ( profil == null ) {
            return null;
        }
        ProfilEnum libelle = profil.getLibelle();
        if ( libelle == null ) {
            return null;
        }
        return libelle;
    }

    protected Profil profilEnumToProfil(ProfilEnum profilEnum) {
        if ( profilEnum == null ) {
            return null;
        }

        Profil profil = new Profil();

        return profil;
    }
}
