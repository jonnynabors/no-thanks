package io.nothanks.nothanks.game;

import io.nothanks.nothanks.card.Card;
import io.nothanks.nothanks.deck.Deck;
import io.nothanks.nothanks.player.Player;
import io.nothanks.nothanks.score.FinalScore;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
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

    public void pickUpCardForPlayer(Player player, int pickedUpChips) {
        player.getCardsInHand().add(deck.getCards().pop());
        player.incrementChipCount(pickedUpChips);
    }

    public void pass(Player player) throws NoChipsInHandException {
        if(player.getChipCount() > 0)
            player.decrementChipCount();
        else{
            throw new NoChipsInHandException();
        }
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<FinalScore> calculateScores() {
        FinalScore finalScore = new FinalScore();
        Player player = getPlayers().get(0);
        player.getCardsInHand().forEach(card -> {
            finalScore.setScore(finalScore.getScore() + card.getValue());
        });
        finalScore.setScore(finalScore.getScore() - player.getChipCount());
        return Collections.singletonList(finalScore);
    }
}
