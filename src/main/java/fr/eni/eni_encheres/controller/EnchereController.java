package fr.eni.eni_encheres.controller;

import fr.eni.eni_encheres.bo.ArticleVendu;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EnchereController {

    @GetMapping("/creerVente")
    public String creerVente(Model model) {
        model.addAttribute("article", new ArticleVendu());
        return "view-NouvelleVente";
    }
}
