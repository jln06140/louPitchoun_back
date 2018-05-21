package co.simplon.service.impl;

import co.simplon.Utils.UtilsUtilisateur;
import co.simplon.controller.dto.EmployeDto;
import co.simplon.controller.mapper.UtilisateurMapper;
import co.simplon.dao.EmployeDao;
import co.simplon.enums.ProfilEnum;
import co.simplon.exception.MotDePasseException;
import co.simplon.model.Profil;
import co.simplon.model.Utilisateur;
import co.simplon.service.EmployeService;
import co.simplon.service.ProfilService;
import co.simplon.service.SectionService;
import co.simplon.service.UtilisateurService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;

@Service
public class EmployeServiceImpl implements EmployeService {

    private static final Logger logger = LogManager.getLogger(EmployeServiceImpl.class);

    @Autowired
    private EmployeDao daoEmploye;

    @Autowired
    private ProfilService profilService;

    @Autowired
    private SectionService sectionService;

    @Autowired
    private UtilisateurMapper utilisateurMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UtilisateurService utilisateurService;

    @Override
    public Set<EmployeDto> getAllEmploye() {
        Profil profil = this.profilService.getProfilByLibelle(ProfilEnum.EMPLOYE);
        return this.utilisateurMapper.mapListUtilisateurToEmployDto(this.daoEmploye.findByProfil(profil));
    }

    @Override
    public EmployeDto addEmploye(EmployeDto employe) throws MotDePasseException {
        logger.info("creation d'un utilisateur : employe");
        //mapping employe en utilisateur
        Utilisateur utilisateur = this.utilisateurMapper.mapEmploye(employe);
        utilisateur.setCreatedDate(LocalDateTime.now());

        //encodage mot de passe
        UtilsUtilisateur.encodeMdp(employe.getMotDePasse(),utilisateur,passwordEncoder);

        utilisateur.setProfil(this.profilService.getProfilByLibelle(employe.getProfil()));
        utilisateur.setSection(this.sectionService.getSectionByNom(employe.getSection()));
        return this.utilisateurMapper.mapEmploye(this.daoEmploye.save(utilisateur));
    }

    @Override
    public EmployeDto getEmploye(Long id) {

        return this.utilisateurMapper.mapEmploye(this.daoEmploye.findOne(id));
    }

    @Override
    public EmployeDto updateEmploye(EmployeDto employe) {
        Utilisateur utilisateur = this.utilisateurMapper.map(this.utilisateurService.getUtilisateur(employe.getId()));
        Utilisateur utilisateurUpdated = this.utilisateurMapper.mapEmploye(employe);

        //verification nouveau mot de passe different de l'ancien
        //recuperation et encodage du nouveau mot de passe
        if (!utilisateur.getMotDePasse().equals(utilisateurUpdated.getMotDePasse())) {
            String NewMotDePasse = this.passwordEncoder.encode(utilisateurUpdated.getMotDePasse());
            utilisateur.setMotDePasse(NewMotDePasse);
        }


        utilisateur.setInfo(utilisateurUpdated.getInfo());

        //en cas de changement de matricule, change egalement le username
        if (!utilisateur.getInfo().getMatricule().equals(utilisateurUpdated.getInfo().getMatricule())){
            utilisateur.setUsername(utilisateurUpdated.getInfo().getMatricule());
        }
        utilisateur.getInfo().setEmail(utilisateurUpdated.getInfo().getEmail());

        //recuperation du profil
        utilisateur.setProfil(this.profilService.getProfilByLibelle(employe.getProfil()));
        utilisateur.setSection(this.sectionService.getSectionByNom(employe.getSection()));

        //mise a jour de la date de moddification
        utilisateur.setUpdatedDate(LocalDateTime.now());
        return this.utilisateurMapper.mapEmploye(this.daoEmploye.save(utilisateur));
    }

    @Override
    public void deleteEmploye(EmployeDto employe) {
        this.daoEmploye.delete(this.utilisateurMapper.mapEmploye(employe));

    }

}
