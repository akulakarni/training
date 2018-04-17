/**
 * 
 */
package com.pkma.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.pkma.spring.common.DBCPDataSourceFactory;
import com.pkma.spring.model.Player;

public class PlayerDAOImplUsingJDBC implements PlayerDAOUsingJDBC {

    @Override
    public List<Player> getAllPlayers() {
        final String query = "select * from player";
        final List<Player> players = new ArrayList<Player>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        final DataSource dataSource = DBCPDataSourceFactory.getDataSource("h2");
        try {
            con = dataSource.getConnection();
            ps = con.prepareStatement(query);
            resultSet = ps.executeQuery();
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
                players.add(player);
            }
        } catch (final SQLException e) {
            e.printStackTrace();
            System.err.println("Exception occured" + e);
        } finally {
            try {
                resultSet.close();
                ps.close();
                con.close();
            } catch (final SQLException e) {
                e.printStackTrace();
            }
        }
        return players;
    }

    @Override
    public Player getPlayer(final Integer playerId) {
        final String query = "select * from player where player_id = ?";
        Player player = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        final DataSource dataSource = DBCPDataSourceFactory.getDataSource("h2");
        try {
            con = dataSource.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, playerId);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                player = new Player();
                player.setAge(resultSet.getInt("age"));
                player.setClub(resultSet.getString("club"));
                player.setCountry(resultSet.getString("country"));
                player.setId(playerId);
                player.setJerseyNumber(resultSet.getInt("jersey_nbr"));
                player.setName(resultSet.getString("name"));
                player.setPosition(resultSet.getString("position"));
                player.setGoals(resultSet.getInt("goals"));
                player.setAssists(resultSet.getInt("assists"));
            }
            if (player != null) {
                System.out.println("Player Found::" + player);
            } else {
                System.out.println("No Player found with id=" + playerId);
            }
        } catch (final SQLException e) {
            System.err.println("Exception occured" + e);
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                ps.close();
                con.close();
            } catch (final SQLException e) {
                e.printStackTrace();
            }
        }
        return player;
    }

    @Override
    public Player createPlayer(final Player player) {
        final String query = "INSERT INTO player (player_id, name, age, club,position,country,jersey_nbr,goals,assists) VALUES (player_Q1.nextval, ?, ?, ?,?,?,?,?,?)";
        Connection con = null;
        PreparedStatement ps = null;
        final DataSource dataSource = DBCPDataSourceFactory.getDataSource("h2");
        try {
            con = dataSource.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, player.getName());
            ps.setInt(2, player.getAge());
            ps.setString(3, player.getClub());
            ps.setString(4, player.getPosition());
            ps.setString(5, player.getCountry());
            ps.setInt(6, player.getJerseyNumber());
            ps.setInt(7, player.getGoals());
            ps.setInt(8, player.getAssists());
            final int out = ps.executeUpdate();
            if (out != 0) {
                System.out.println("Employee saved with name=" + player.getName());
            } else {
                System.out.println("Employee save failed with name=" + player.getName());
            }
        } catch (final SQLException e) {
            System.err.println("Exception occured" + e);
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                con.close();
            } catch (final SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Player updatePlayer(final Player player) {
        final String query = "update player set name= ?, age= ?, club= ?,position= ?,country= ?,jersey_nbr= ?,goals= ?,assists = ? where player_id = ?";
        Connection con = null;
        PreparedStatement ps = null;
        final DataSource dataSource = DBCPDataSourceFactory.getDataSource("h2");
        try {
            con = dataSource.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, player.getName());
            ps.setInt(2, player.getAge());
            ps.setString(3, player.getClub());
            ps.setString(4, player.getPosition());
            ps.setString(5, player.getCountry());
            ps.setInt(6, player.getJerseyNumber());
            ps.setInt(7, player.getGoals());
            ps.setInt(8, player.getAssists());
            ps.setInt(9, player.getId());
            final int out = ps.executeUpdate();
            if (out != 0) {
                System.out.println("Employee saved with id=" + player.getId());
            } else {
                System.out.println("Employee save failed with id=" + player.getId());
            }
        } catch (final SQLException e) {
            System.err.println("Exception occured" + e);
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                con.close();
            } catch (final SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Player deletePlayer(final Integer playerId) {
        final String query = "delete from player where player_id = ?";
        Connection con = null;
        PreparedStatement ps = null;
        final DataSource dataSource = DBCPDataSourceFactory.getDataSource("h2");
        try {
            con = dataSource.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, playerId);
            final int out = ps.executeUpdate();
            if (out != 0) {
                System.out.println("Employee deleted with id=" + playerId);
            } else {
                System.out.println("Employee deleted failed with id=" + playerId);
            }
        } catch (final SQLException e) {
            System.err.println("Exception occured" + e);
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                con.close();
            } catch (final SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
