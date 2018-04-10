package io.nothanks.nothanks.player;


import java.util.ArrayList;
import java.util.List;

public class Player {

    private int chipCount;
    private List<Integer> cardsInHand;

    public static Player withDefaultChipCount() {
        Player player = new Player();
        List<Integer> initialCards = new ArrayList<>();
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

    public List<Integer> getCardsInHand() {
        return cardsInHand;
    }

    public void setCardsInHand(List<Integer> cardsInHand) {
        this.cardsInHand = cardsInHand;
    }

    public void incrementChipCount(int newChips) {
        this.chipCount += newChips;
    }

    public void decrementChipCount() {
        this.chipCount--;
    }
}
