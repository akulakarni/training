/**
 * 
 */
package com.pkma.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.pkma.spring.model.Player;
import com.pkma.spring.sql.PlayerSQL;

public class PlayerDAOImplUsingJDBCTemplate implements PlayerDAOUsingJDBCTemplate {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private SequenceDao sequenceDao;

    @Override
    public List<Player> getAllPlayers() {
        final String sql = PlayerSQL.GET_ALL_PLAYERS;
        final List<Player> players = jdbcTemplate.query(sql, new RowMapper<Player>() {
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
        });
        return players;
    }

    @Override
    public Player getPlayer(final Integer playerId) {
        final String sql = "select * from player where player_id =" + playerId;
        return jdbcTemplate.queryForObject(sql, new RowMapper<Player>() {

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
        });
        // This is the best practice we need to follow up
        // return jdbcTemplate.query(sql,new Object[]{playerId},playerResultSetExtractor);
    }

    @Override
    // @Transactional(readOnly = false, propagation = Propagation.MANDATORY)
    public Player createPlayer(final Player player) {
        try {
            // final String sql =
            // "INSERT INTO player (player_id, name, age, club, position, country, jersey_nbr, goals, assists) VALUES (player_Q1.nextval,?,?,?,?,?,?,?,?)";
            final String sql = "INSERT INTO player (player_id, name, age, club, position, country, jersey_nbr, goals, assists) VALUES (?,?,?,?,?,?,?,?,?)";
            jdbcTemplate.update(
                    sql,
                    new Object[]{player.getId(), player.getName(), player.getAge(), player.getClub(),
                            player.getPosition(), player.getCountry(), player.getJerseyNumber(), player.getGoals(),
                            player.getAssists()});
            System.out.println("Created Record for Name = " + player.getName() + " Age = " + player.getAge()
                    + " Club = " + player.getClub());
        } catch (final DataAccessException exp) {// dont use sys err
            exp.printStackTrace();
            System.err.println("Exception occured" + exp);
        }
        return null;
    }

    @Override
    // @Transactional(readOnly = true, propagation = Propagation.MANDATORY)
    public Player updatePlayer(final Player player) {
        try {
            final String sql = "update player set name= ?, age= ?, club= ?,position= ?,country= ?,jersey_nbr= ?,goals = ?,assists = ? where player_id = ?";
            jdbcTemplate.update(
                    sql,
                    new Object[]{player.getName(), player.getAge(), player.getClub(), player.getPosition(),
                            player.getCountry(), player.getJerseyNumber(), player.getGoals(), player.getAssists(),
                            player.getId()});
            System.out.println("Update Record for Name = " + player.getName() + " Age = " + player.getAge()
                    + " Club = " + player.getClub());// dont use sysout
        } catch (final DataAccessException exp) {
            // dont use sys err
            exp.printStackTrace();
            System.err.println("Exception occured" + exp);
        }
        return null;
    }

    @Override
    public Player deletePlayer(final Integer playerId) {
        try {
            final String sql = "delete from player where player_id = ?";
            jdbcTemplate.update(sql, new Object[]{playerId});
            System.out.println("Deleted Record for player with id = " + playerId);// dont use sysout
        } catch (final DataAccessException exp) {
            // dont use sys err
            exp.printStackTrace();
            System.err.println("Exception occured" + exp);
        }
        return null;
    }

    @Override
    public List<Player> getPlayerUsingBeanPropertyRowMapper() {

        final String sql = PlayerSQL.GET_ALL_PLAYERS;
        // This is the best practice we need to follow up
        final List<Player> players = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Player>(Player.class));
        return players;

    }
}
