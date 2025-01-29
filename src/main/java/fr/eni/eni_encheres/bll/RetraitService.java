package fr.eni.eni_encheres.bll;

import fr.eni.eni_encheres.bo.Retrait;

public interface RetraitService {
    void addRetrait(Retrait retrait);


    void deleteRetrait(int noArticle);



    Retrait getRetraitByNoArticle(int noArticle);

    void updateRetrait(Retrait retrait);
}
