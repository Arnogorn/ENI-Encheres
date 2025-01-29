package fr.eni.eni_encheres.dal;

import fr.eni.eni_encheres.bo.Utilisateur;


import java.util.List;

public interface DAOUtilisateur {


    int create(Utilisateur utilisateurs);

    List<Utilisateur> read();

    Utilisateur read(int id);

    void update(Utilisateur utilisateurs);

    void delete(Utilisateur utilisateurs);

    void delete(int noUtilisateur);
}
