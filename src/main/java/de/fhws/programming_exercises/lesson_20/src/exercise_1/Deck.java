package de.fhws.programming_exercises.lesson_20.src.exercise_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck{
    private final List<Card> cards = new ArrayList<>();
    private int cardsNum = 0;

    public Deck(boolean shuffle){
        resetDeck(shuffle);
    }

    public Card drawCard(){
        return cards.remove(0);
    }

    public void resetDeck(boolean shuffle){
        for (Suit s : Suit.values()){
            for (Rank r : Rank.values()){
                cards.add(new Card(s, r));
                cardsNum++;
            }
        }
        if (shuffle){
            shuffleDeck();
        }
    }

    public void shuffleDeck(){
        Collections.shuffle(cards);
    }

    public List<Card> getCards(){
        return cards;
    }

    public int getCardsNum(){
        return cardsNum;
    }
}
