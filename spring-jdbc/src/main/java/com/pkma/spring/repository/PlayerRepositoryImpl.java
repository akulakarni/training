package com.pkma.spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pkma.spring.dao.PlayerDAOUsingJDBC;
import com.pkma.spring.dao.PlayerDAOUsingJDBCTemplate;
import com.pkma.spring.dao.PlayerDAOUsingNamedParameterJDBCTemplate;
import com.pkma.spring.model.Player;

public class PlayerRepositoryImpl implements PlayerRepository {
    @Autowired
    private PlayerDAOUsingJDBC playerDAOUsingJDBC;
    @Autowired
    private PlayerDAOUsingJDBCTemplate playerDAOUsingJDBCTemplate;
    @Autowired
    private PlayerDAOUsingNamedParameterJDBCTemplate playerDAOUsingNamedParameterJDBCTemplate;

    // replace bean name in all method calls in order to test plain jdbc,named parameter jdbc
    @Override
    public List<Player> getAllPlayers() {
        return playerDAOUsingJDBCTemplate.getAllPlayers();
    }

    @Override
    public Player getPlayer(final Integer playerId) {
        return playerDAOUsingJDBCTemplate.getPlayer(playerId);
    }

    @Override
    public Player createPlayer(final Player player) {
        return playerDAOUsingJDBCTemplate.createPlayer(player);
    }

    @Override
    public Player updatePlayer(final Player player) {
        return playerDAOUsingJDBCTemplate.updatePlayer(player);
    }

    @Override
    public Player deletePlayer(final Integer playerId) {
        return playerDAOUsingJDBCTemplate.deletePlayer(playerId);
    }

}
