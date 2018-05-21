package co.simplon.Utils;

import co.simplon.exception.MotDePasseException;
import co.simplon.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UtilsUtilisateur {


    public static void encodeMdp(String mdp,Utilisateur utilisateur, PasswordEncoder passwordEncoder) throws MotDePasseException {
        if(utilisateur.getMotDePasse() != null || !utilisateur.getMotDePasse().isEmpty()) {
            utilisateur.setMotDePasse(passwordEncoder.encode(utilisateur.getMotDePasse()));
        }else{
            throw new MotDePasseException("Mot de passe vide");
        }
    }
}
