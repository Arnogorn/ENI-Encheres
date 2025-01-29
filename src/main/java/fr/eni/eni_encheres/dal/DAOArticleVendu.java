package fr.eni.eni_encheres.dal;

import fr.eni.eni_encheres.bo.ArticleVendu;

import java.util.List;

public interface DAOArticleVendu {
    int create(ArticleVendu articleVendu);

    List<ArticleVendu> read();

    ArticleVendu read(int noArticle);

    void update(ArticleVendu articleVendu);

    void delete(ArticleVendu articleVendu);

    void delete(int noArticle);
}
