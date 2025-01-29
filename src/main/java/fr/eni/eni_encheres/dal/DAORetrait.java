package fr.eni.eni_encheres.dal;

import fr.eni.eni_encheres.bo.Retrait;

public interface DAORetrait {
    int create(Retrait retrait);



    Retrait read(int noArticle);


    void update(Retrait retrait);

    void delete(Retrait retrait);




    void delete(int noArticle);

}
