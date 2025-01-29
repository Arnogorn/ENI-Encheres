package fr.eni.eni_encheres.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.security.provisioning.UserDetailsManager;

@Controller
public class ConnexionController {
    protected final Log logger = LogFactory.getLog(getClass());


    //Mise en commentaire momentanée pour éviter les complications lors du développement

    //private UserDetailManager userDetailManager;

    @GetMapping("/login")
    public String login() {
        logger.info("Login Page");
        return "login";
    }

    @PostMapping("/logout")
    public String performLogout(HttpServletRequest request) {
//        if (SecurityContextHolder.getContext().getAuthentication() != null) {
//
//            request.getSession().invalidate();
//            SecurityContextHolder.clearContext();
//        }
        return "redirect:/listeObjet";
    }
}
