package com.pkma.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pkma.spring.model.Player;

public class PlayerRowMapper implements RowMapper<Player> {

    @Override
    public Player mapRow(final ResultSet resultSet, final int rowNum) throws SQLException {
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
}
