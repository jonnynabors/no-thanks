package io.nothanks.nothanks.deck;

import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Deck {

    private Stack<Integer> cards;

    private static List<Integer> initializeDeck() {
       return IntStream.rangeClosed(3, 35)
                .boxed().collect(Collectors.toList());
    }

    public static Deck with9CardsRemoved() {
        Deck deck = new Deck();
        List<Integer> initialDeck = initializeDeck();
        Collections.shuffle(initialDeck);

        Stack<Integer> cardsStack = new Stack<>();
        cardsStack.addAll(initialDeck.subList(0, 24));
        deck.setCards(cardsStack);
        return deck;
    }

    public Stack<Integer> getCards() {
        return cards;
    }

    public void setCards(Stack<Integer> cards) {
        this.cards = cards;
    }
}
