package fr.eni.eni_encheres.bll;

import fr.eni.eni_encheres.bo.Enchere;

import java.util.List;

public interface EnchereService {
    void addEnchere(Enchere enchere);

    void deleteEnchere(int noArticle, int noUtilisateur);

    List<Enchere> getEnchere();

    Enchere getEnchereByNoArticleNNoUtilisateur(int noArticle, int noUtilisateur);

    Enchere getEnchereByNoArticleNNoUtilisateur(int noArticle);

    void updateEnchere(Enchere enchere);
}
