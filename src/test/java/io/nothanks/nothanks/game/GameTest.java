package io.nothanks.nothanks.game;

import io.nothanks.nothanks.card.Card;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GameTest {

    private Game game = new Game();

    @Test
    public void shouldDealTopCardOfDeckWhenGameStarts() {
        game.initializeGame();
        Card card = game.dealCard();
    }

}