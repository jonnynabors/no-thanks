package io.nothanks.nothanks.game;

import io.nothanks.nothanks.card.Card;
import io.nothanks.nothanks.deck.Deck;
import org.springframework.stereotype.Component;

@Component
public class Game {

    private Deck deck;

    public void initializeGame() {
        deck = Deck.with9CardsRemoved();
    }

    public Card dealCard() {
        return null;
    }
}
