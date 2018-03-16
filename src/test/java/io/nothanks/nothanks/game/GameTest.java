package io.nothanks.nothanks.game;

import io.nothanks.nothanks.card.Card;
import io.nothanks.nothanks.player.Player;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameTest {

    private Game game = new Game();

    @Test
    public void shouldDealTopCardOfDeckWhenGameStarts() {
        game.initializeGame();
        Card card = game.dealCard();
        assertTrue(card.getValue() >= 3);
    }

    @Test
    public void shouldAddCardAndTokensToPlayerHand() {
        Player player1 = Player.withDefaultChipCount();
        Game singlePlayerGame = Game.withOnePlayer(player1);
        singlePlayerGame.initializeGame();
        singlePlayerGame.dealCard();
        singlePlayerGame.pickUpCardForPlayer(player1, 17);
        assertEquals(1, singlePlayerGame.getPlayers().get(0).getCardsInHand().size());
        assertEquals(28, singlePlayerGame.getPlayers().get(0).getChipCount());
    }

}