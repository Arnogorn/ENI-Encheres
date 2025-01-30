package fr.eni.eni_encheres.bll;

import fr.eni.eni_encheres.bo.Categorie;

import java.util.List;

public interface CategorieService {
    void addCategorie(Categorie categorie);

    void deleteCategorie(int noArticle);

    List<Categorie> getCategorie();

    Categorie getCategoriebyID(int noCategorie);

    void updateCategorie(Categorie categorie);
}
