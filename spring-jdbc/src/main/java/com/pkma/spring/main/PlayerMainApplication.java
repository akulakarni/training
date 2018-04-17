/**
 * 
 */
package com.pkma.spring.main;

import java.sql.SQLException;
import java.util.List;

import org.h2.tools.Server;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pkma.spring.dao.PlayerDAOUsingJDBCTemplate;
import com.pkma.spring.dao.SequenceDao;
import com.pkma.spring.model.Player;

public class PlayerMainApplication {
    public static void main(final String[] args) throws SQLException {

        final AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        // start the TCP Server
        final Server server = Server.createTcpServer(args).start();

        final SequenceDao sequenceDao = (SequenceDao) context.getBean("sequenceDao");
        final PlayerDAOUsingJDBCTemplate playerDAOUsingJDBCTemplate = (PlayerDAOUsingJDBCTemplate) context
                .getBean("playerDAOUsingJDBCTemplate");

        // This will get all palyers from DB..using row mapper
        final List<Player> players = playerDAOUsingJDBCTemplate.getPlayerUsingBeanPropertyRowMapper();
        for (final Player player : players) {
            System.out.println(player);
        }

        /*
         * // This will fetch player with the given id final Player player = playerDAOUsingJDBCTemplate.getPlayer(10);
         * System.out.println(player);
         * 
         * // This will create player with the given user input final int playerId =
         * sequenceDao.getPlayerId("player_Q1"); final Player createPlayer = new Player(playerId, "Mesut Ozil", 26,
         * "Arsenal", "Atacking Midfielder", "Germany", 8, 1, 1);
         * 
         * playerDAOUsingJDBCTemplate.createPlayer(createPlayer);
         * 
         * // This will get all palyers from DB final List<Player> newlyCreatedPlayers =
         * playerDAOUsingJDBCTemplate.getAllPlayers(); System.out.println(newlyCreatedPlayers);
         * 
         * // This will create player with the given user input final Player updatePlayer = new Player(playerId,
         * "Mesut Ozil", 27, "FC Schalke", "Atacking Midfielder", "Germany", 8, 1, 1);
         * 
         * playerDAOUsingJDBCTemplate.updatePlayer(updatePlayer);
         * 
         * // This will get all palyers from DB final List<Player> newlyUpdatedPlayers =
         * playerDAOUsingJDBCTemplate.getAllPlayers(); System.out.println(newlyUpdatedPlayers);
         */
        // stop the TCP Server
        server.stop();
    }
}
