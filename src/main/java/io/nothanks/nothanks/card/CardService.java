package io.nothanks.nothanks.card;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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


}
