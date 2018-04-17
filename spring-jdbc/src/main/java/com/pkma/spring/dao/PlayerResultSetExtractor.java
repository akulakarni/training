package com.pkma.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.pkma.spring.model.Player;

public class PlayerResultSetExtractor implements ResultSetExtractor<Player> {

    // Out of ways of writing resultset extractor...below is one way of writing resultset extractor
    @Override
    public Player extractData(final ResultSet resultSet) throws SQLException, DataAccessException {
        while (resultSet.next()) {
            final Player player = new Player();
            player.setAge(resultSet.getInt("age"));
            player.setClub(resultSet.getString("club"));
            player.setCountry(resultSet.getString("country"));
            player.setId(resultSet.getInt("player_id"));
            player.setJerseyNumber(resultSet.getInt("jersey_nbr"));
            player.setName(resultSet.getString("name"));
            player.setPosition(resultSet.getString("position"));
            player.setGoals(resultSet.getInt("goals"));
            player.setAssists(resultSet.getInt("assists"));
            return player;
        }
        return null;
    }

    // Out of ways of writing resultset extractor...below is another way of writing resultset extractor
    /*
     * @Autowired private PlayerRowMapper rowMapper;
     * 
     * @Override public Player extractData(final ResultSet resultSet) throws SQLException, DataAccessException { // one
     * way of writing resultset extractor int rowNum = 0; while (resultSet.next()) { final Player player =
     * rowMapper.mapRow(resultSet, rowNum++); return player; } return null; }
     */
}
