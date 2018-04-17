/**
 * 
 */
package com.pkma.spring.dao;

import java.util.List;

import com.pkma.spring.model.Player;

public interface PlayerDAOUsingNamedParameterJDBCTemplate {
    List<Player> getAllPlayers();
    Player getPlayer(Integer playerId);
    Player createPlayer(Player player);
    Player updatePlayer(Player player);
    Player deletePlayer(Integer playerId);
}
