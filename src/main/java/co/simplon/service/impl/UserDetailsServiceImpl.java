package co.simplon.service.impl;

import co.simplon.controller.dto.UserDto;
import co.simplon.exception.PitchounErrorEnum;
import co.simplon.exception.PitchounException;
import co.simplon.model.Utilisateur;
import co.simplon.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UtilisateurService utilisateurService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        /*final Utilisateur utilisateur = this.utilisateurService.findByEmail(email);

        final Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(utilisateur.getProfil().getLibelle().name()));

        return new UserDto(
                utilisateur.getId(),
                utilisateur.getUsername(),
                utilisateur.getMotDePasse(),
                utilisateur.getEmail(),
                authorities,
                utilisateur.isActif(),
                LocalDate.now(),
                "saltquisertarien"
        );*/
        return new UserDto(
                1L,
                "toto",
                "toto",
                "toto@docapost.fr",
                Arrays.asList(new SimpleGrantedAuthority("ADMIN")),
                true,
                LocalDate.now(),
                "saltquisertarien"
        );
    }
}
