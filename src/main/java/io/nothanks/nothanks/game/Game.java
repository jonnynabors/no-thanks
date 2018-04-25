package io.nothanks.nothanks.game;

import io.nothanks.nothanks.deck.Deck;
import io.nothanks.nothanks.player.Player;
import org.javatuples.Pair;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Game {

    private Deck deck;
    private List<Player> players;
    private int chipCount;

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public static Game withOnePlayer(Player player1) {
        Game game = new Game();
        List<Player> gamePlayers = new ArrayList<>();
        gamePlayers.add(player1);
        game.setPlayers(gamePlayers);
        return game;
    }

    public static Game withTwoPlayers(Player player1, Player player2) {
        Game game = new Game();
        List<Player> gamePlayers = new ArrayList<>();
        gamePlayers.add(player1);
        gamePlayers.add(player2);
        game.setPlayers(gamePlayers);
        return game;
    }

    public void initializeGame() {
        deck = Deck.with9CardsRemoved();
        chipCount = 1;
        players.get(0).decrementChipCount();
    }

    public Pair<Integer, Integer> dealCard() {
        return new Pair<>(deck.getCards().peek(), chipCount);
    }

    public void pickUpCardForPlayer(Player player, int pickedUpChips) {
        player.getCardsInHand().add(deck.getCards().pop());
        player.incrementChipCount(pickedUpChips);
    }

    public void pass(Player player) throws NoChipsInHandException {
        if (player.getChipCount() > 0)
            player.decrementChipCount();
        else {
            throw new NoChipsInHandException();
        }
    }

}
