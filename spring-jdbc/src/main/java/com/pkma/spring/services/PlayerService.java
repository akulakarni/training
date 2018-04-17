package com.pkma.spring.services;

import java.util.List;

import com.pkma.spring.model.Player;


public interface PlayerService {
    List<Player> getAllPlayers();
    Player getPlayer(Integer playerId);
    Player createPlayer(Player player);
    Player updatePlayer(Player player);
    Player deletePlayer(Integer playerId);
}
