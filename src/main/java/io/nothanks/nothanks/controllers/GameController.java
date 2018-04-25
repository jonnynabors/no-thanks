package io.nothanks.nothanks.controllers;

import io.nothanks.nothanks.game.Game;
import io.nothanks.nothanks.player.Player;
import org.javatuples.Pair;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

    private Player player1 = new Player();
    private Game game;

    @PostMapping(value = "game/create/{playerCount}")
    public Integer createGame(@PathVariable int playerCount) {
        game = Game.withOnePlayer(player1);
        game.initializeGame();
        return 1;
    }

    //TODO: Make outputs of methods Strings for more legible output
    @GetMapping(value = "game/showCard")
    public Pair<Integer, Integer> showCard(){
        return game.dealCard();
    }

}
