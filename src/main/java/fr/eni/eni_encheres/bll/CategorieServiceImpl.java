package fr.eni.eni_encheres.bll;

import fr.eni.eni_encheres.bo.Categorie;
import fr.eni.eni_encheres.dal.DAOCategorie;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategorieServiceImpl implements CategorieService {


    private DAOCategorie daoCategorie;

    public CategorieServiceImpl(DAOCategorie daoCategorie) {
        this.daoCategorie = daoCategorie;
    }

    @Override
    public void addCategorie(Categorie categorie) {
        daoCategorie.create(categorie);
    }

    @Override
    public void deleteCategorie(int noArticle) {
        daoCategorie.delete(noArticle);
    }

    @Override
    public List<Categorie> getCategorie() {
        return daoCategorie.read();
    }

    @Override
    public Categorie getCategoriebyID(int noArticle) {
        return daoCategorie.read(noArticle);
    }

    @Override
    public void updateCategorie(Categorie categorie) {
        daoCategorie.update(categorie);
    }
}
