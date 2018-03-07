package io.nothanks.nothanks.player;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void shouldInitializeNewPlayersWith11Tokens(){
        Player newPlayer = Player.withDefaultChipCount();
        assertEquals(11, newPlayer.getChipCount());
    }

}