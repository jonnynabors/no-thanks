package io.nothanks.nothanks.game;

import io.nothanks.nothanks.player.Player;
import org.javatuples.Pair;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameTest {

    private Player player1;
    @Before
    public void setup() {
        player1 = Player.withDefaultChipCount();
    }

    //TODO: Split the responsibilities of this test.
    @Test
    public void shouldDealTopCardOfDeckWhenGameStartsAndChargePlayer1OneChip() {
        Game game = Game.withOnePlayer(player1);
        game.initializeGame();
        Pair<Integer, Integer> firstCardAndChipCount = game.dealCard();
        assertEquals(10, game.getPlayers().get(0).getChipCount());
        assertTrue(firstCardAndChipCount.getValue0() >= 3);
        assertEquals((Integer) 1, firstCardAndChipCount.getValue1());
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

    //TODO: Figure out how to best test game ending
    @Test
    public void gameEndsWhenNoCardsAreLeftInDeck() {
    }

}