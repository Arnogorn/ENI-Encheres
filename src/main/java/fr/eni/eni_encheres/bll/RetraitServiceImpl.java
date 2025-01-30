package fr.eni.eni_encheres.bll;

import fr.eni.eni_encheres.bo.Retrait;
import fr.eni.eni_encheres.dal.DAORetrait;
import org.springframework.stereotype.Service;

@Service
public class RetraitServiceImpl implements RetraitService{


    private DAORetrait daoRetrait;

    public RetraitServiceImpl(DAORetrait daoRetrait) {
        this.daoRetrait = daoRetrait;
    }

    @Override
    public void addRetrait(Retrait retrait) {daoRetrait.create(retrait);}

    @Override
    public void deleteRetrait(int noArticle) {
        daoRetrait.delete(noArticle);
    }



    @Override
    public Retrait getRetraitByNoArticle(int noArticle) {
        return daoRetrait.read(noArticle);
    }

    @Override
    public void updateRetrait(Retrait retrait) {
        daoRetrait.update(retrait);
    }
}
