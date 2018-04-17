package com.pkma.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pkma.spring.model.Player;
import com.pkma.spring.services.PlayerService;
@Controller
@RequestMapping(value = "/player/")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @RequestMapping(value = "find", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, headers = "Accept=application/json")
    public @ResponseBody
    List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @ResponseBody
    @RequestMapping(value = "{playerId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Player getPlayer(@PathVariable final Integer playerId) {
        return playerService.getPlayer(playerId);
    }

    @ResponseBody
    @RequestMapping(value = "create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Player createPlayer(@RequestBody final Player player) {
        return playerService.createPlayer(player);
    }

    @ResponseBody
    @RequestMapping(value = "update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Player updatePlayer(@RequestBody final Player player) {
        return playerService.updatePlayer(player);
    }

    @ResponseBody
    @RequestMapping(value = "{playerId}/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Player deletePlayer(@PathVariable final Integer playerId) {
        return playerService.deletePlayer(playerId);
    }
}
