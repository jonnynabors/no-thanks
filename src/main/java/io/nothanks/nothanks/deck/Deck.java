package io.nothanks.nothanks.deck;

import io.nothanks.nothanks.card.Card;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Deck {

    private Set<Card> cards;

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
        deck.setCards(new HashSet<>(initialDeck.subList(0, 24)));
        return deck;
    }

    public Set<Card> getCards() {
        return cards;
    }

    public void setCards(Set<Card> cards) {
        this.cards = cards;
    }
}
