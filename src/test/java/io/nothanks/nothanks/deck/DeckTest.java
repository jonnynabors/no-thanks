package io.nothanks.nothanks.deck;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeckTest {

    @Test
    public void shouldBuildDeckOf32CardsAndRemove9CardsRandomly() {
        Deck deck = Deck.with9CardsRemoved();

        assertEquals(24, deck.getCards().size());
    }

}