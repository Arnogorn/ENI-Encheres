package fr.eni.eni_encheres.bll;

import fr.eni.eni_encheres.bo.Retrait;



public interface RetraitService {

    //Create
    void addRetrait(Retrait retrait);

    //Supprimer
    void deleteRetrait(int noArticle);

    //Retrouver Article par l'ID
    Retrait getRetraitByNoArticle(int noArticle);

    //Modifier
    void updateRetrait(Retrait retrait);
}
