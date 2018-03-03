package io.nothanks.nothanks.card;

import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class CardServiceTest {

    private CardService cardService = new CardService();

    @Test
    public void shouldBuildDeckOf32Cards() {
        List<Card> actual = cardService.initializeDeck();

        assertEquals(33, actual.size());
    }

    @Test
    public void shouldRemove9CardsRandomly() {
        Set<Card> actual = cardService.buildDeckWith9CardsRemoved();

        assertEquals(24, actual.size());
    }



}