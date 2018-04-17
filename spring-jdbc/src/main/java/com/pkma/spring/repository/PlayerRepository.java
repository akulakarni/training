package com.pkma.spring.repository;

import java.util.List;

import com.pkma.spring.model.Player;


public interface PlayerRepository {
    List<Player> getAllPlayers();
    Player getPlayer(Integer playerId);
    Player createPlayer(Player player);
    Player updatePlayer(Player player);
    Player deletePlayer(Integer playerId);
}
