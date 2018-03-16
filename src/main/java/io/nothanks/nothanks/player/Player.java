package io.nothanks.nothanks.player;


import io.nothanks.nothanks.card.Card;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private int chipCount;
    private List<Card> cardsInHand;

    public static Player withDefaultChipCount() {
        Player player = new Player();
        List<Card> initialCards = new ArrayList<>();
        player.setChipCount(11);
        player.setCardsInHand(initialCards);
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

    public void incrementChipCount(int newChips) {
        this.chipCount += newChips;
    }
}
