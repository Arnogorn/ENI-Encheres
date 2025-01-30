package fr.eni.eni_encheres.controller;

import jakarta.validation.Valid;
import org.springframework.ui.Model;
import fr.eni.eni_encheres.bll.UtilisateurService;
import fr.eni.eni_encheres.bo.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    // Afficher la liste des utilisateurs dans une view
    @GetMapping
    public String getAllUtilisateurs(Model model) {
        List<Utilisateur> utilisateurs = utilisateurService.getAllUtilisateurs();
        model.addAttribute("utilisateurs", utilisateurs);
        return "view-utilisateurs";
    }

    // Afficher les détails d'un utilisateur
    @GetMapping("/{noUtilisateur}")
    public String getUtilisateurByNoUtilisateur(@PathVariable int noUtilisateur, Model model) {
        Utilisateur utilisateur = utilisateurService.getUtilisateurByNoUtilisateur(noUtilisateur);
        if (utilisateur != null) {
            model.addAttribute("utilisateur", utilisateur);
            return "utilisateurs/details";
        } else {
            return "view-errors404"; // Vue pour une page d'erreur (404)
        }
    }

    // Form pour ajouter un utilisateur
    @GetMapping("/nouveau")
    public String showCreateForm(Model model) {
        model.addAttribute("utilisateur", new Utilisateur());
        return "utilisateurs/form";
    }

    // Soumettre le formulaire pour créer un utilisateur
    @PostMapping
    public String addUtilisateur(@Valid @ModelAttribute("utilisateur") Utilisateur utilisateur) {
        utilisateurService.addUtilisateur(utilisateur);
        return "redirect:/index"; // Redirige vers la liste après la création (sisi la famille)
    }

    // Formulaire pour modifier un utilisateur
    @GetMapping("/modifier/{noUtilisateur}")
    public String showUpdateForm(@PathVariable int noUtilisateur, Model model) {
        Utilisateur utilisateur = utilisateurService.getUtilisateurByNoUtilisateur(noUtilisateur);
        if (utilisateur != null) {
            model.addAttribute("utilisateur", utilisateur);
            return "utilisateurs/form"; // Réutilise le même formulaire pour la modification
        } else {
            return "view-errors404"; // Vue pour une page d'erreur 404 (à ajouter plus tard)
        }
    }

    // Soumettre le formulaire pour modifier un utilisateur
    @PostMapping("/modifier/{noUtilisateur}")
    public String update(@Valid @ModelAttribute("utilisateur") Utilisateur utilisateur) {
        utilisateurService.update(utilisateur);
        return "redirect:/view-utilisateurs";
    }

    // Supprimer un utilisateur
    @GetMapping("/supprimer/{noUtilisateur}")
    public String deleteUtilisateur(@PathVariable int noUtilisateur) {
        utilisateurService.deleteUtilisateur(noUtilisateur);
        return "redirect:/index";
    }
}