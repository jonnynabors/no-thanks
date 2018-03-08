package io.nothanks.nothanks.game;

import io.nothanks.nothanks.card.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Game {

    private CardService cardService;

    @Autowired
    public Game(CardService cardService) {
        this.cardService = cardService;
    }

    public void initializeGame() {
        cardService.initializeDeck();
        cardService.buildDeckWith9CardsRemoved();
    }
}
