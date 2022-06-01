package de.fhws.programming_exercises.lesson_20.src.exercise_1;

public enum Rank{
    ACE("A", 1),
    TWO("2", 2),
    THREE("3", 3),
    FOUR("4", 4),
    FIVE("5", 5),
    SIX("6", 6),
    SEVEN("7", 7),       // +2
    EIGHT("8", 8),       // skip/cancel +2
    NINE("9", 9),        // direction change
    TEN("10", 10),
    JACK("J", 11),       // allows player to change suit
    QUEEN("Q", 12),
    KING("K", 13);

    final String symbol;
    final int value;

    Rank(String symbol, int value){
        this.symbol = symbol;
        this.value = value;
    }
}
