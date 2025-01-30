package fr.eni.eni_encheres.controller;

import fr.eni.eni_encheres.bll.ArticleVenduService;
import fr.eni.eni_encheres.bll.RetraitService;
import fr.eni.eni_encheres.bo.ArticleVendu;
import fr.eni.eni_encheres.bo.Retrait;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RetraitController {
    private RetraitService retraitService;
    private ArticleVenduService articleVenduService;

    protected final Log logger = LogFactory.getLog(getClass());


    public RetraitController(RetraitService retraitService,ArticleVenduService articleVenduService) {
        this.retraitService = retraitService;
        this.articleVenduService = articleVenduService;

    }
    @GetMapping("/creeRetrait")
    public String addRetrait(@ModelAttribute Retrait retrait, Model model) {
        model.addAttribute("retrait", new Retrait());
        retraitService.addRetrait(retrait);
        return "view-retrait";
    }

    @PostMapping("/creeRetrait")
    public String newRetrait(@ModelAttribute Retrait retrait, Model model){
        retraitService.addRetrait(retrait);
        System.out.println(retrait);
        System.out.println(model);
        return "/retrait";
    }
    @PostMapping("/retrait")
    public String deleteRetrait(@RequestParam(name = "no_article") int no_article, Model model) {
        retraitService.deleteRetrait(no_article);
        logger.info("Afficher de la liste des retraits");
        return "redirect:/retrait";
    }
    @GetMapping("/modifier")
    public String updateRetrait(@RequestParam(name = "no_article") int no_article, Model model) {
        model.addAttribute("retrait", new Retrait());
        model.addAttribute("retrait", retraitService.getRetraitByNoArticle(no_article));

        return "view-retrait";
    }

    @PostMapping("/modifier")
    public String modifyChat(@RequestParam(name = "no_article") int no_article, @ModelAttribute Retrait retrait, Model model) {
        var retraitModif = retraitService.getRetraitByNoArticle(no_article);
        System.out.println("Donnée de retrait reçu :");
        System.out.println("Rue: " + retrait.getRue());
        System.out.println("Code postal: " + retrait.getCodePostal());
        System.out.println("Ville: " + retrait.getVille());
        retraitService.updateRetrait(retrait);

        return "redirect:/retrait";
    }

}
