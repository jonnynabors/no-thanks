package io.nothanks.nothanks.game;

import io.nothanks.nothanks.player.Player;
import io.nothanks.nothanks.score.FinalScore;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameTest {

    private Game game = new Game();
    private Player player1;
    @Before
    public void setup() {
        player1 = Player.withDefaultChipCount();
    }

    @Test
    public void shouldDealTopCardOfDeckWhenGameStarts() {
        game.initializeGame();
        Integer firstCard = game.dealCard();
        assertTrue(firstCard >= 3);
    }

    @Test
    public void shouldAddCardAndTokensToPlayerHand() {
        Game singlePlayerGame = Game.withOnePlayer(player1);
        singlePlayerGame.initializeGame();
        singlePlayerGame.dealCard();
        singlePlayerGame.pickUpCardForPlayer(player1, 17);
        assertEquals(1, singlePlayerGame.getPlayers().get(0).getCardsInHand().size());
        assertEquals(28, singlePlayerGame.getPlayers().get(0).getChipCount());
    }

    @Test
    public void shouldBeAbleToPassIfChipCountAtLeastOne() throws NoChipsInHandException {
        Game singlePlayerGame = Game.withOnePlayer(player1);
        singlePlayerGame.initializeGame();
        singlePlayerGame.dealCard();
        singlePlayerGame.pass(player1);
        assertEquals(10, singlePlayerGame.getPlayers().get(0).getChipCount());
    }

    @Test(expected = NoChipsInHandException.class)
    public void shouldNotBeAbleToPassIfChipCountIsZero() throws NoChipsInHandException {
        player1.setChipCount(0);
        Game singlePlayerGame = Game.withOnePlayer(player1);
        singlePlayerGame.initializeGame();
        singlePlayerGame.dealCard();
        singlePlayerGame.pass(player1);
    }

    @Test
    public void shouldCountTokensAsNegativePoints() {
        player1.setCardsInHand(Arrays.asList(21, 15));
        player1.setChipCount(7);
        Game singlePlayerGame = Game.withOnePlayer(player1);
        List<FinalScore> actualScores = singlePlayerGame.calculateScores();
        assertEquals(29, actualScores.get(0).getScore());
    }

    @Test
    public void shouldCalculateRunsOfCards() {
        player1.setCardsInHand(Arrays.asList(4, 16, 15, 17));

        Game singlePlayerGame = Game.withOnePlayer(player1);
        List<FinalScore> actualScores = singlePlayerGame.calculateScores();
        assertEquals(8, actualScores.get(0).getScore());
    }
}