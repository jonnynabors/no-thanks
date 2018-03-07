package io.nothanks.nothanks.player;


import io.nothanks.nothanks.card.Card;

import java.util.List;

public class Player {

    private int chipCount;
    private List<Card> cardsInHand;

    public static Player withDefaultChipCount() {
        Player player = new Player();
        player.setChipCount(11);
        return player;
    }

    public int getChipCount() {
        return chipCount;
    }

    public void setChipCount(int chipCount) {
        this.chipCount = chipCount;
    }

    public List<Card> getCardsInHand() {
        return cardsInHand;
    }

    public void setCardsInHand(List<Card> cardsInHand) {
        this.cardsInHand = cardsInHand;
    }

}
