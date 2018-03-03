package io.nothanks.nothanks.card;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CardServiceTest {

    private CardService cardService = new CardService();

    @Test
    public void shouldBuildDeckOf32Cards() {
        List<Card> actual = cardService.initializeDeck();

        assertEquals(33, actual.size());
    }



}