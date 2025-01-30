package fr.eni.eni_encheres.controller;

import fr.eni.eni_encheres.bo.ArticleVendu;

import fr.eni.eni_encheres.bll.ArticleVenduService;
import fr.eni.eni_encheres.bll.CategorieService;
import fr.eni.eni_encheres.bll.UtilisateurService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;







@Controller
public class EnchereController {

    private ArticleVenduService articleVenduService;
    private UtilisateurService utilisateurService;
    private CategorieService categorieService;


    public EnchereController(ArticleVenduService articleVenduService, UtilisateurService utilisateurService, CategorieService categorieService) {
        this.articleVenduService = articleVenduService;
        this.utilisateurService = utilisateurService;
        this.categorieService = categorieService;

    }
    @GetMapping("/creerVente")
    public String creerVente(Model model) {
        model.addAttribute("articleVendu", new ArticleVendu());
        return "view-NouvelleVente";
    }
    @GetMapping("/listeObjet")
    public String listeObjet(Model model) {
        var articleVendu = articleVenduService.getArticleVendu();

        model.addAttribute("articleVendu", articleVendu);

        return "view-ListeEncheres";
    }





}
