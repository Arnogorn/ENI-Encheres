package fr.eni.eni_encheres.dal;


import fr.eni.eni_encheres.bll.CategorieService;
import fr.eni.eni_encheres.bll.UtilisateurService;
import fr.eni.eni_encheres.bo.ArticleVendu;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ArticleRowMappper implements RowMapper<ArticleVendu> {

    private UtilisateurService utilisateurService;
    private CategorieService categorieService;

    public ArticleRowMappper(UtilisateurService utilisateurService, CategorieService categorieService) {
        this.utilisateurService = utilisateurService;
        this.categorieService = categorieService;
    }

    @Override
    public ArticleVendu mapRow(ResultSet rs, int rowNum) throws SQLException {
        ArticleVendu articleVendu = new ArticleVendu();
        int refAcheteur = (rs.getInt("no_utilisateur"));
        int refCategorie = (rs.getInt("no_categorie"));
        articleVendu.setNoArticle(rs.getInt("no_article"));
        articleVendu.setNomArticle(rs.getString("nom_article"));
        articleVendu.setDescription(rs.getString("description"));
        articleVendu.setDateDebutEncheres(rs.getTimestamp("date_debut_encheres").toLocalDateTime().toLocalDate());
        articleVendu.setDateFinEncheres(rs.getTimestamp("date_fin_encheres").toLocalDateTime().toLocalDate());
        articleVendu.setMiseAPrix(rs.getInt("prix_initial"));
        articleVendu.setPrixVente(rs.getInt("prix_vente"));
        articleVendu.setUtilisateur(utilisateurService.getUtilisateurByNoUtilisateur(refAcheteur));
        articleVendu.setCategorie(categorieService.getCategoriebyID(refCategorie));
        return articleVendu;
    }
}
