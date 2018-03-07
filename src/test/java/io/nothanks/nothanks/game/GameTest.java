package io.nothanks.nothanks.game;

import io.nothanks.nothanks.card.CardService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GameTest {

    @Mock
    private CardService cardService;

    private Game game = new Game(cardService);

    @Test
    @Ignore("come back to this, ran out of time")
    public void shouldInitializeGame() {
        game.initializeGame();
        Mockito.verify(cardService).initializeDeck();
        Mockito.verify(cardService).buildDeckWith9CardsRemoved();
    }

}