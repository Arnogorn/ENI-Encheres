package fr.eni.eni_encheres.bll;

import fr.eni.eni_encheres.bo.Utilisateur;

import java.util.List;

public interface UtilisateurService {
    void addUtilisateur(Utilisateur utilisateur);

    void deleteUtilisateur(int noUtilisateur);

    List<Utilisateur> getUtilisateur();

    Utilisateur getUtilisateurByNoUtilisateur(int noUtilisateur);


}
