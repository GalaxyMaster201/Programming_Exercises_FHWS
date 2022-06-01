package de.fhws.programming_exercises.lesson_20.src.exercise_1;

import java.util.Collection;
import java.util.TreeSet;

public class Player{
    private final String name;
    private final Collection<Card> hand = new TreeSet<>();

    public Player(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public Collection<Card> getHand(){
        return hand;
    }

    public void drawCard(Deck deck){
        hand.add(deck.drawCard());
    }
}
