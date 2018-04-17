/**
 * 
 */
package com.pkma.spring.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pkma.spring.model.Player;
import com.pkma.spring.sql.PlayerSQL;

public class PlayerDAOImplUsingNamedParameterJDBCTemplate implements PlayerDAOUsingNamedParameterJDBCTemplate {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    private PlayerResultSetExtractor playerResultSetExtractor;
    @Autowired
    private PlayerRowMapper playerRowMapper;
    @Autowired
    private SequenceDao sequenceDao;

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Player> getAllPlayers() {
        final String sql = PlayerSQL.GET_ALL_PLAYERS;
        final List<Player> players = namedParameterJdbcTemplate.query(sql, playerRowMapper);
        return players;
    }

    @Override
    // @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Player getPlayer(final Integer playerId) {
        final String sql = PlayerSQL.GET_PLAYER;
        final MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("player_id", playerId);
        return namedParameterJdbcTemplate.queryForObject(sql, params, playerRowMapper);
    }

    @Override
    // @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Player createPlayer(final Player player) {
        final String sql = PlayerSQL.CREATE_PLAYER;
        final MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", player.getName());
        params.addValue("age", player.getAge());
        params.addValue("club", player.getClub());
        params.addValue("position", player.getPosition());
        params.addValue("country", player.getCountry());
        params.addValue("jersey_nbr", player.getJerseyNumber());
        params.addValue("goals", player.getGoals());
        params.addValue("assists", player.getAssists());
        final int i = namedParameterJdbcTemplate.update(sql, params);
        if (i == 0) {
            // failed to insert
            System.out.println("Failed to insert Record for Name = " + player.getName() + " Age = " + player.getAge()
                    + " Club = " + player.getClub());
        }
        System.out.println("Created Record for Name = " + player.getName() + " Age = " + player.getAge() + " Club = "
                + player.getClub());
        return null;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Player updatePlayer(final Player player) {
        final String sql = PlayerSQL.UPDATE_PLAYER;
        final MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("player_id", player.getId());
        params.addValue("name", player.getName());
        params.addValue("age", player.getAge());
        params.addValue("club", player.getClub());
        params.addValue("position", player.getPosition());
        params.addValue("country", player.getCountry());
        params.addValue("jersey_nbr", player.getJerseyNumber());
        params.addValue("goals", player.getJerseyNumber());
        params.addValue("assists", player.getJerseyNumber());
        final int i = namedParameterJdbcTemplate.update(sql, params);
        if (i == 0) {
            // failed to insert
            System.out.println("Failed to update Record for Name = " + player.getName() + " Age = " + player.getAge()
                    + " Club = " + player.getClub());// dont use sysout
        }
        System.out.println("updated Record for Name = " + player.getName() + " Age = " + player.getAge() + " Club = "
                + player.getClub());// dont use sysout
        return null;
    }

    @Override
    // @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Player deletePlayer(final Integer playerId) {
        final String sql = PlayerSQL.DELETE_PLAYER;
        final MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("player_id", playerId);
        final int i = namedParameterJdbcTemplate.update(sql, params);
        if (i == 0) {
            // failed to insert
            System.out.println("Failed to delete Record for player with id = " + playerId);// dont use sysout
        }
        System.out.println("Deleted Record for player with id = " + playerId);// dont use sysout

        return null;
    }
}
