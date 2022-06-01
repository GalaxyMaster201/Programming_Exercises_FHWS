package de.fhws.programming_exercises.lesson_20.src.exercise_2;

public enum Suit{
    SPADES("\u2660", 100),
    CLUBS("\u2663", 200),
    HEARTS("\u2661", 300),
    DIAMONDS("\u2662", 400);

    final String symbol;
    final int value;

    Suit(String symbol, int value){
        this.symbol = symbol;
        this.value = value;
    }
}
