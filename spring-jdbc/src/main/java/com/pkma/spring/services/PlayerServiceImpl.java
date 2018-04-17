package com.pkma.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pkma.spring.model.Player;
import com.pkma.spring.repository.PlayerRepository;

public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.getAllPlayers();
    }

    @Override
    public Player getPlayer(final Integer playerId) {
        return playerRepository.getPlayer(playerId);
    }

    @Override
    public Player createPlayer(final Player player) {
        return playerRepository.createPlayer(player);
    }

    @Override
    public Player updatePlayer(final Player player) {
        return playerRepository.updatePlayer(player);
    }

    @Override
    public Player deletePlayer(final Integer playerId) {
        return playerRepository.deletePlayer(playerId);
    }

}
