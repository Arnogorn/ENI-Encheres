//package fr.eni.eni_encheres.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//import org.springframework.security.provisioning.UserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//import javax.sql.DataSource;
//
////@EnableWebSecurity
////@Configuration
//public class SecurityConfiguration {
//    private final DataSource dataSource;
//
//
//
//    public SecurityConfiguration(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
//
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder(); // Utilisation de l'encodeur BCrypt pour les mots de passe
//    }
//
//    @Bean
//    UserDetailsManager userDetailsManager(DataSource dataSource) {
//        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
////        jdbcUserDetailsManager.setUsersByUsernameQuery("select pseudo,password,1 from utilisateur where pseudo=?");
////        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select pseudo,role from roles where pseudo=?");
//
//
//        return jdbcUserDetailsManager;
//    }
//    @Bean
//    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.csrf(AbstractHttpConfigurer::disable);
//        http.authorizeHttpRequests(auth -> {
//
//            auth.requestMatchers(HttpMethod.GET, "/index").permitAll();
//            auth.requestMatchers("/creerUtilisateur").permitAll();
////            auth.requestMatchers(HttpMethod.POST, "/Liste").hasRole("ADMIN");
////            auth.requestMatchers(HttpMethod.GET, "/Liste").permitAll();
////            auth.requestMatchers(HttpMethod.GET, "/detail").hasRole("UTILISATEUR");
////            auth.requestMatchers(HttpMethod.GET, "/detail").hasRole("UTILISATEUR");
////            auth.requestMatchers(HttpMethod.GET, "/creer").hasRole("ADMIN");
////            auth.requestMatchers(HttpMethod.POST, "/creer").hasRole("ADMIN");
////            auth.requestMatchers(HttpMethod.GET, "/modifier").hasRole("ADMIN");
////            auth.requestMatchers(HttpMethod.POST, "/modifier").hasRole("ADMIN");
//
//
//            //Permettre à tous les utilisateurs d'afficher correctement les images et la css
//            auth.requestMatchers("/css/*").permitAll();
//            auth.requestMatchers("/images/*").permitAll();
//            auth.anyRequest().permitAll();
//        });
//        //formulaire de connexion par défaut
//        http.formLogin(form -> form
//                        .loginPage("/login")
//                        .permitAll())
//                .logout(logout -> logout
//                        .logoutUrl("/logout")  // URL de déconnexion (quand l'utilisateur clique pour se déconnecter)
//                        .logoutSuccessUrl("/ListeObjet")  // Page de redirection après la déconnexion
//                        .invalidateHttpSession(true)
//                        .deleteCookies("JSESSIONID")// Invalider la session HTTP après la déconnexion
//                        .clearAuthentication(true)    // Effacer l'authentification
//                        .permitAll()                  // Permet à tout le monde d'accéder à la déconnexion
//                );
//        // Autres configurations de sécurité
//
//
////déconnexion de l'utilisateur
//
//
//        return http.build();
//    }
//}
