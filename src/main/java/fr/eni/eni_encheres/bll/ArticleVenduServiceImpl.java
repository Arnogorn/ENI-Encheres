package fr.eni.eni_encheres.bll;

import fr.eni.eni_encheres.bo.ArticleVendu;
import fr.eni.eni_encheres.dal.DAOArticleVendu;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleVenduServiceImpl implements ArticleVenduService {

    private DAOArticleVendu daoArticleVendu;

    public ArticleVenduServiceImpl(DAOArticleVendu daoArticleVendu) {
        this.daoArticleVendu = daoArticleVendu;
    }

    @Override
    public void addArticleVendu(ArticleVendu articleVendu) {
        daoArticleVendu.create(articleVendu);
    }

    @Override
    public void deleteArticleVendu(int noArticle) {
        daoArticleVendu.delete(noArticle);
    }

    @Override
    public List<ArticleVendu> getArticleVendu() {
        return daoArticleVendu.read();
    }

    @Override
    public ArticleVendu getArticleVendubyID(int noArticle) {
        return daoArticleVendu.read(noArticle);
    }

    @Override
    public void updateArticleVendu(ArticleVendu articleVendu) {
        daoArticleVendu.update(articleVendu);
    }
}
