/**
 * 
 */
package com.pkma.spring.dao;

import java.util.List;

import com.pkma.spring.model.Player;

public interface PlayerDAOUsingJDBCTemplate {
    List<Player> getAllPlayers();
    Player getPlayer(Integer playerId);
    List<Player> getPlayerUsingBeanPropertyRowMapper();
    Player createPlayer(Player player);
    Player updatePlayer(Player player);
    Player deletePlayer(Integer playerId);
}
