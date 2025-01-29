package fr.eni.eni_encheres.bll;

import fr.eni.eni_encheres.bo.ArticleVendu;

import java.util.List;

public interface ArticleVenduService {

    void addArticleVendu(ArticleVendu articleVendu);

    void deleteArticleVendu(int noArticle);

    List<ArticleVendu> getArticleVendu();

    ArticleVendu getArticleVendubyID(int noArticle);

    void updateArticleVendu(ArticleVendu articleVendu);
}
