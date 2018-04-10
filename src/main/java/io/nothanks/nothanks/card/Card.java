package io.nothanks.nothanks.card;

public class Card implements Comparable<Card>{

    private Integer value;

    public Card(Integer value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Card o) {
        return this.value - o.value;
    }
}
