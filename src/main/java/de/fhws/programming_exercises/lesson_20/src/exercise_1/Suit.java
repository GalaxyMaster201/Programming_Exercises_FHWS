package de.fhws.programming_exercises.lesson_20.src.exercise_1;

public enum Suit{
    SPADES("\u2660", 100),
    HEARTS("\u2661", 200),
    DIAMONDS("\u2662", 300),
    CLUBS("\u2663", 400);

    final String symbol;
    final int value;

    Suit(String symbol, int value){
        this.symbol = symbol;
        this.value = value;
    }
}
