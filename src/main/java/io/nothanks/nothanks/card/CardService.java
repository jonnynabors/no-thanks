package io.nothanks.nothanks.card;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class CardService {

    public List<Card> initializeDeck() {
        List<Card> initialDeckOf32Cards = new ArrayList<>();

        List<Integer> range = IntStream.rangeClosed(3, 35)
                .boxed().collect(Collectors.toList());

        range.forEach(cardValue -> initialDeckOf32Cards.add(new Card(cardValue)));
        return initialDeckOf32Cards;
    }

    public Set<Card> buildDeckWith9CardsRemoved() {
        List<Card> initialDeck = initializeDeck();
        Collections.shuffle(initialDeck);
        return new HashSet<>(initialDeck.subList(0, 24));
    }
}
