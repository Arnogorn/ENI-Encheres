package fr.eni.eni_encheres.bll;

import fr.eni.eni_encheres.bo.Enchere;
import fr.eni.eni_encheres.dal.DAOEnchere;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnchereServiceImpl implements EnchereService{


    private DAOEnchere daoEnchere;

    public EnchereServiceImpl(DAOEnchere daoEnchere) {
        this.daoEnchere = daoEnchere;
    }

    @Override
    public void addEnchere(Enchere enchere) {
        daoEnchere.create(enchere);
    }

    @Override
    public void deleteEnchere(int noArticle, int noUtilisateur) {
        daoEnchere.delete(noArticle, noUtilisateur);
    }

    @Override
    public List<Enchere> getEnchere() {
        return daoEnchere.read();
    }

    @Override
    public Enchere getEnchereByNoArticleNNoUtilisateur(int noArticle, int noUtilisateur) {
        return null;
    }

    @Override
    public Enchere getEnchereByNoArticleNNoUtilisateur(int noArticle) {
        return daoEnchere.read(noArticle);
    }

    @Override
    public void updateEnchere(Enchere enchere) {
        daoEnchere.update(enchere);
    }
}
