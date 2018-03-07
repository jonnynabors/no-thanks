package io.nothanks.nothanks.game;

import io.nothanks.nothanks.card.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Game {

    @Autowired
    private CardService cardService;

    public Game(CardService cardService) {
        this.cardService = cardService;
    }

    public void initializeGame() {
        cardService.initializeDeck();
        cardService.buildDeckWith9CardsRemoved();
    }
}
