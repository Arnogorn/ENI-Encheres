package fr.eni.eni_encheres.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArticleVenduController {

    @GetMapping("/listeObjet")
    public String listeObjet() {
        return "index";
    }

}
