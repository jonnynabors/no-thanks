package io.nothanks.nothanks.game;

import io.nothanks.nothanks.deck.Deck;
import io.nothanks.nothanks.player.Player;
import io.nothanks.nothanks.score.FinalScore;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Component
public class Game {

    private Deck deck;
    private List<Player> players;

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

    public void initializeGame() {
        deck = Deck.with9CardsRemoved();
    }

    public Integer dealCard() {
        return deck.getCards().peek();
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

    public List<FinalScore> calculateScores() {
        FinalScore finalScore = new FinalScore();
        Player player = this.players.get(0);
        List<Integer> cardsInHand = player.getCardsInHand();
        Collections.sort(cardsInHand);
        int currentPointValue = 0;
        for (int i = 0; i < cardsInHand.size(); i++) {
            currentPointValue += cardsInHand.get(i);
            if (i != 0 && cardsInHand.get(i - 1) + 1 == cardsInHand.get(i)) {
                currentPointValue -= cardsInHand.get(i);
            }
        }
        finalScore.setScore(currentPointValue - player.getChipCount());
        return Collections.singletonList(finalScore);
    }

}
