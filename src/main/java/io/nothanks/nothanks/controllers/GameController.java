package io.nothanks.nothanks.controllers;

import io.nothanks.nothanks.game.Game;
import io.nothanks.nothanks.player.Player;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Tuple;

@RestController
public class GameController {

    Player player1 = new Player();
    Game game;

    //TODO: Handle creating game through an API
    @PostMapping(value = "game/create/{playerCount}")
    public Integer createGame(@PathVariable int playerCount) {
        game = Game.withOnePlayer(player1);
        game.initializeGame();
        return 1;
    }

    @GetMapping(value = "game/showCard")
    public int showCard(){
        return game.dealCard();
    }

}
