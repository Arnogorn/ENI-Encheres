package fr.eni.eni_encheres.dal;

import fr.eni.eni_encheres.bo.Retrait;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DAORetraitSQL implements DAORetrait {
    static final String SELECT_ALL = "select * from retrait";
    static final String SELECT_BY_NO_ARTICLE = "select * from retrait where no_article=?";
    static final String INSERT = "INSERT  INTO retrait ([rue],[code_postal],[ville]) VALUES (:rue,:code_postal,:ville)";
    static final String DELETE = "DELETE FROM retrait where no_article=?";
    static final String UPDATE = "UPDATE retrait set rue=?,code_postal=? where ville=?";


    JdbcTemplate jdbcTemplate;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public DAORetraitSQL(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }


    @Override
    public int create(Retrait retrait){
        var namedparameters = new MapSqlParameterSource();
        namedparameters.addValue("no_article", retrait.getArticleVendu().getNoArticle());
        namedparameters.addValue("rue", retrait.getRue());
        namedparameters.addValue("code_postal", retrait.getCodePostal());
        namedparameters.addValue("ville", retrait.getVille());

        namedParameterJdbcTemplate.update(INSERT, namedparameters);

        return retrait.getArticleVendu().getNoArticle();

    }
    @Override
    public Retrait read(int no_article) {
        return jdbcTemplate.queryForObject(SELECT_BY_NO_ARTICLE, BeanPropertyRowMapper.newInstance(Retrait.class), no_article);
    }

    @Override
    public void update(Retrait retrait) {
        jdbcTemplate.update(UPDATE, retrait.getRue(), retrait.getCodePostal(), retrait.getVille());
    }

    @Override
    public void delete(Retrait retrait){
delete(retrait.getArticleVendu().getNoArticle());
    }

    @Override
    public void delete(int noArticle) {
        jdbcTemplate.update(DELETE, noArticle);
    }
}



