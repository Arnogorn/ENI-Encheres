package fr.eni.eni_encheres.dal;

import fr.eni.eni_encheres.bo.Enchere;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DAOEnchereSQL implements DAOEnchere {

    static final String SELECT_ALL = "SELECT * from Encheres";
    static final String SELECT_BY_ID = "SELECT * from Encheres where no_article=? and no_utilisateur=?";
    static final String INSERT = "INSERT  INTO Encheres ([date_enchere],[montant_enchere]) VALUES (:date_enchere,:montant_enchere)";
    static final String DELETE = "DELETE FROM Encheres where no_article=? and no_utilisateur=?";
    static final String UPDATE = "UPDATE Encheres set date_enchere=?,montant_enchere=? where no_article=? and no_utilisateur=?";

    JdbcTemplate jdbcTemplate;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public DAOEnchereSQL(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Enchere create(Enchere enchere) {
        var namedparameters = new MapSqlParameterSource();
        namedparameters.addValue("no_article", enchere.getArticleVendu().getNoArticle());
        namedparameters.addValue("no_utilisateur", enchere.getUtilisateur().getNoUtilisateur());
        namedparameters.addValue("date_enchere", enchere.getDateEnchere());
        namedparameters.addValue("montant_enchere", enchere.getMontantEnchere());
        namedParameterJdbcTemplate.update(INSERT, namedparameters);
        return enchere;
    }

    @Override
    public List<Enchere> read() {
        return jdbcTemplate.query(SELECT_ALL, BeanPropertyRowMapper.newInstance(Enchere.class));
    }

    @Override
    public Enchere read(int id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID, BeanPropertyRowMapper.newInstance(Enchere.class), id);
    }

    @Override
    public void update(Enchere enchere) {
        jdbcTemplate.update(UPDATE, enchere.getDateEnchere(), enchere.getMontantEnchere());
    }

    @Override
    public void delete(Enchere enchere) {
        delete(enchere.getArticleVendu().getNoArticle(), enchere.getUtilisateur().getNoUtilisateur());
    }

    @Override
    public void delete(int noArticle, int noUtilisateur) {
        jdbcTemplate.update(DELETE, noArticle, noUtilisateur);
    }






}
