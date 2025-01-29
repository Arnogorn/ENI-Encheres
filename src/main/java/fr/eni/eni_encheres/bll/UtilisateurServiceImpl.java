package fr.eni.eni_encheres.bll;

import fr.eni.eni_encheres.bo.Utilisateur;
import fr.eni.eni_encheres.dal.DAOUtilisateur;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    private DAOUtilisateur daoUtilisateur;

    public UtilisateurServiceImpl(DAOUtilisateur daoUtilisateur) {
        this.daoUtilisateur = daoUtilisateur;
    }

    @Override
    public void addUtilisateur(Utilisateur utilisateur) {
        daoUtilisateur.create(utilisateur);
    }

    @Override
    public void deleteUtilisateur(int noUtilisateur) {
        daoUtilisateur.delete(noUtilisateur);
    }

    @Override
    public List<Utilisateur> getUtilisateur() {
        return daoUtilisateur.read();
    }

    @Override
    public Utilisateur getUtilisateurByNoUtilisateur(int noUtilisateur) {
        return daoUtilisateur.read(noUtilisateur);
    }
}
