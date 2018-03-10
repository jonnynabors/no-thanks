package io.nothanks.nothanks.deck;

import io.nothanks.nothanks.card.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Deck {

    private Stack<Card> cards;

    private static List<Card> initializeDeck() {
        List<Card> initialDeckOf32Cards = new ArrayList<>();

        List<Integer> range = IntStream.rangeClosed(3, 35)
                .boxed().collect(Collectors.toList());

        range.forEach(cardValue -> initialDeckOf32Cards.add(new Card(cardValue)));
        return initialDeckOf32Cards;
    }

    public static Deck with9CardsRemoved() {
        Deck deck = new Deck();
        List<Card> initialDeck = initializeDeck();
        Collections.shuffle(initialDeck);

        Stack<Card> cardsStack = new Stack<>();
        cardsStack.addAll(initialDeck.subList(0, 24));
        deck.setCards(cardsStack);
        return deck;
    }

    public Stack<Card> getCards() {
        return cards;
    }

    public void setCards(Stack<Card> cards) {
        this.cards = cards;
    }
}
