package io.nothanks.nothanks.game;

import io.nothanks.nothanks.card.Card;
import io.nothanks.nothanks.deck.Deck;
import io.nothanks.nothanks.player.Player;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Game {

    private Deck deck;
    private List<Player> players;

    public static Game withOnePlayer(Player player1) {
        Game game = new Game();
        List<Player> players = new ArrayList<>();
        players.add(player1);
        game.setPlayers(players);
        return game;
    }

    public void initializeGame() {
        deck = Deck.with9CardsRemoved();
    }

    public Card dealCard() {
        return deck.getCards().peek();
    }

    public void pickUpCardForPlayer(Player player, int i) {
        player.getCardsInHand().add(deck.getCards().pop());
        player.incrementChipCount(i);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
