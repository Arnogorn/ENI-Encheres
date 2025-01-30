package fr.eni.eni_encheres.controller;

import fr.eni.eni_encheres.bll.ArticleVenduService;
import fr.eni.eni_encheres.bo.ArticleVendu;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class ArticleVenduController {

    @Autowired
    private ArticleVenduService articleVenduService;

    @PostMapping("/creerVente")
    public String creerVente(@ModelAttribute("articleVendu") ArticleVendu articleVendu, Model model) {
        articleVenduService.addArticleVendu(articleVendu);
        model.addAttribute("articleVendu", articleVendu);
        return "redirect:/view-ListeEncheres";
    }
}
