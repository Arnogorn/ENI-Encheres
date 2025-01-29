package fr.eni.eni_encheres.bo;

import java.time.LocalDate;

public class Enchere {
    private LocalDate dateEnchere;
    private int montantEnchere;
    private Utilisateur utilisateur;
    private ArticleVendu articleVendu;

    public Enchere() {
    }

    public Enchere(LocalDate dateEnchere, int montantEnchere, Utilisateur utilisateur, ArticleVendu articleVendu) {
        this.dateEnchere = dateEnchere;
        this.montantEnchere = montantEnchere;
        this.utilisateur = utilisateur;
        this.articleVendu = articleVendu;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public ArticleVendu getArticleVendu() {
        return articleVendu;
    }

    public LocalDate getDateEnchere() {
        return dateEnchere;
    }

    public void setDateEnchere(LocalDate dateEnchere) {
        this.dateEnchere = dateEnchere;
    }

    public int getMontantEnchere() {
        return montantEnchere;
    }

    public void setMontantEnchere(int montantEnchere) {
        this.montantEnchere = montantEnchere;
    }
}
