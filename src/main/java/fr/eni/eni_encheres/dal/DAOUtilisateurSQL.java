package fr.eni.eni_encheres.dal;

import fr.eni.eni_encheres.bo.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DAOUtilisateurSQL implements DAOUtilisateur{

    static final String SELECT_ALL = "SELECT * from utilisateur";
    static final String SELECT_BY_ID = "SELECT * from utilisateur where no_utilisateur = :no_utilisateur";
    static final String SELECT_BY_PSEUDO = "SELECT * from utilisateur where pseudo = :pseudo";
    static final String INSERT = "INSERT  INTO utilisateur ([pseudo],[nom],[prenom],[email],[telephone],[rue],[code_postal],[ville],[mot_de_passe],[credit],[administrateur]) VALUES (:psuedo,:nom,:prenom,:email,:telephone,:rue,:code_postal,:ville,:mot_de_passe,0,0)";
    static final String DELETE = "DELETE FROM utilisateur where no_utilisateur=?";
    static final String UPDATE = "UPDATE utilisateur set pseudo=?,nom=?,prenom=?,email=?,telephone=?,rue=?,code_postal=?,ville=?,mot_de_passe=?,credit=?,administrateur=? where id=?";



    JdbcTemplate jdbcTemplate;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;



//    PasswordEncoder passwordEncoder;

    public DAOUtilisateurSQL(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;

    }

    @Override
    public int create(Utilisateur utilisateurs) {
////j'ai rajouté ça pour voir si le bcrypt en base de donnée changeait qqchose
//        String encodedPassword = passwordEncoder.encode(utilisateurs.getMotDePasse());
//        utilisateurs.setMotDePasse(encodedPassword);
        var namedparameters = new MapSqlParameterSource();

        namedparameters.addValue("pseudo", utilisateurs.getPseudo());
        namedparameters.addValue("nom", utilisateurs.getNom());
        namedparameters.addValue("prenom", utilisateurs.getPrenom());
        namedparameters.addValue("email", utilisateurs.getEmail());
        namedparameters.addValue("telephone", utilisateurs.getTelephone());
        namedparameters.addValue("rue", utilisateurs.getRue());
        namedparameters.addValue("code_postal", utilisateurs.getCodePostal());
        namedparameters.addValue("ville", utilisateurs.getVille());
        namedparameters.addValue("mot_de_passe", utilisateurs.getMotDePasse());
        namedparameters.addValue("credit", utilisateurs.getCredit());
        namedparameters.addValue("admin", utilisateurs.isAdministrateur());

        var keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(INSERT, namedparameters, keyHolder);

        return keyHolder.getKey().intValue();
    }

    @Override
    public List<Utilisateur> read() {
        return jdbcTemplate.query(SELECT_ALL, BeanPropertyRowMapper.newInstance(Utilisateur.class));
    }
    @Override
    public Utilisateur read(int noUtilisateur) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID, BeanPropertyRowMapper.newInstance(Utilisateur.class), noUtilisateur);
    }

    @Override
    public void update(Utilisateur utilisateurs) {
        jdbcTemplate.update(UPDATE, utilisateurs.getPseudo(), utilisateurs.getNom(), utilisateurs.getPrenom(), utilisateurs.getEmail(), utilisateurs.getTelephone(), utilisateurs.getRue(), utilisateurs.getCodePostal(), utilisateurs.getVille(), utilisateurs.getMotDePasse(), utilisateurs.getCredit(), utilisateurs.isAdministrateur());
    }

    @Override
    public void delete(Utilisateur utilisateurs) {
        delete(utilisateurs.getNoUtilisateur());
    }

    @Override
    public void delete(int noUtilisateur) {
        jdbcTemplate.update(DELETE, noUtilisateur);
    }
}

