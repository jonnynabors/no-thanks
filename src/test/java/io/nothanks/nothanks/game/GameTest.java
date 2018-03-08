package io.nothanks.nothanks.game;

import io.nothanks.nothanks.card.CardService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class GameTest {

    @Mock
    private CardService cardService;

    @InjectMocks
    private Game game = new Game(cardService);

    @Test
    public void shouldInitializeGame() {
        game.initializeGame();
        verify(cardService).initializeDeck();
        verify(cardService).buildDeckWith9CardsRemoved();
    }

}