package de.fhws.programming_exercises.lesson_20.src.exercise_1;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

//TODO turn into an actual game
public class Game{
    private final Deck deck = new Deck(true);

    private final Player p1 = new Player("Steven");
    private final Player p2 = new Player("George");


    public void start(){
        enableSymbols();
        initializePlayers();
    }

    private void initializePlayers(){
        for (int i = 0; i < 5; i++){
            p1.drawCard(deck);
            p2.drawCard(deck);
        }
    }

    private void enableSymbols(){
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, StandardCharsets.UTF_8));
    }
}


