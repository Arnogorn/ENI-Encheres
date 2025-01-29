package fr.eni.eni_encheres.bo;

public class Retrait {
    private String rue;
    private String codePostal;
    private String ville;
    private ArticleVendu articleVendu;

    public Retrait() {
    }

    public Retrait(String rue, String codePostal, String ville, ArticleVendu articleVendu) {
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
        this.articleVendu = articleVendu;
    }

    public ArticleVendu getArticleVendu() {
        return articleVendu;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
}
