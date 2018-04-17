package io.nothanks.nothanks.player;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    @Test
    public void shouldInitializeNewPlayersWith11Tokens(){
        Player newPlayer = Player.withDefaultChipCount();
        assertEquals(11, newPlayer.getChipCount());
    }

    @Test
    public void shouldScoreConsecutiveRunsOfCards() {
        Player newPlayer = Player.withDefaultChipCount();
        newPlayer.setCardsInHand(Arrays.asList(15, 16, 17));
        assertEquals(4, newPlayer.calculateScores());
    }

    @Test
    public void shouldScoreConsecutiveRunsOfCardsWhenNonConsecutiveCardsExist() {
        Player newPlayer = Player.withDefaultChipCount();
        newPlayer.setCardsInHand(Arrays.asList(3, 7, 15, 16, 17, 19, 20, 21, 22, 35));
        assertEquals(68, newPlayer.calculateScores());
    }

}