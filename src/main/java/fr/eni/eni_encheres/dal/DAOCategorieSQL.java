package fr.eni.eni_encheres.dal;

import fr.eni.eni_encheres.bo.Categorie;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DAOCategorieSQL implements DAOCategorie {

    static final String SELECT_ALL = "SELECT * from Categories";
    static final String SELECT_BY_ID = "SELECT * from Categories where no_categorie=?";
    static final String INSERT = "INSERT  INTO Categories ([libelle]) VALUES (:libelle)";
    static final String DELETE = "DELETE FROM Categories where no_categorie=?";
    static final String UPDATE = "UPDATE Categories set libelle=? where no_categorie=?";

    JdbcTemplate jdbcTemplate;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public DAOCategorieSQL(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public int create(Categorie categorie) {
        var namedparameters = new MapSqlParameterSource();
        namedparameters.addValue("libelle", categorie.getLibelle());
        var keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(INSERT, namedparameters, keyHolder);
        return keyHolder.getKey().intValue();
    }

    @Override
    public List<Categorie> read() {
        return jdbcTemplate.query(SELECT_ALL, BeanPropertyRowMapper.newInstance(Categorie.class));
    }

    @Override
    public Categorie read(int id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID, BeanPropertyRowMapper.newInstance(Categorie.class), id);
    }

    @Override
    public void update(Categorie categorie) {
        jdbcTemplate.update(UPDATE, categorie.getLibelle());
    }

    @Override
    public void delete(Categorie categorie) {
        delete(categorie.getNoCategorie());
    }

    @Override
    public void delete(int noCategorie) {
        jdbcTemplate.update(DELETE, noCategorie);
    }






}
