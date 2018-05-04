package co.simplon.controller.mapper;

import co.simplon.controller.dto.ParentDto;
import co.simplon.controller.dto.UtilisateurDto;
import co.simplon.enums.ProfilEnum;
import co.simplon.model.Profil;
import co.simplon.model.Utilisateur;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class UtilisateurMapperImpl implements UtilisateurMapper {

    @Override
    public ParentDto mapParent(Utilisateur user) {
        if ( user == null ) {
            return null;
        }

        ParentDto parentDto = new ParentDto();

        parentDto.setMotDePasse( user.getMotDePasse() );
        parentDto.setProfil( user.getProfil() );
        parentDto.setInfo( user.getInfo() );

        return parentDto;
    }

    @Override
    public Utilisateur map(ParentDto user) {
        if ( user == null ) {
            return null;
        }

        Utilisateur utilisateur = new Utilisateur();

        utilisateur.setMotDePasse( user.getMotDePasse() );
        utilisateur.setProfil( user.getProfil() );
        utilisateur.setInfo( user.getInfo() );

        return utilisateur;
    }

    @Override
    public UtilisateurDto map(Utilisateur utilisateur) {
        if ( utilisateur == null ) {
            return null;
        }

        UtilisateurDto utilisateurDto = new UtilisateurDto();

        ProfilEnum libelle = utilisateurProfilLibelle( utilisateur );
        if ( libelle != null ) {
            utilisateurDto.setProfil( libelle );
        }
        utilisateurDto.setEmail( utilisateur.getEmail() );
        utilisateurDto.setMotDePasse( utilisateur.getMotDePasse() );

        return utilisateurDto;
    }

    @Override
    public List<UtilisateurDto> map(List<Utilisateur> utilisateur) {
        if ( utilisateur == null ) {
            return null;
        }

        List<UtilisateurDto> list = new ArrayList<UtilisateurDto>( utilisateur.size() );
        for ( Utilisateur utilisateur1 : utilisateur ) {
            list.add( map( utilisateur1 ) );
        }

        return list;
    }

    private ProfilEnum utilisateurProfilLibelle(Utilisateur utilisateur) {
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
}
