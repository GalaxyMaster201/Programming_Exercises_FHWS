package de.fhws.programming_exercises.lesson_20.src.exercise_2;


import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class Skat{
    private final Deck deck = new Deck(true);

    private final Player p1 = new Player("Steven");

    public static void main(String[] args){
        Skat s = new Skat();
        s.start();
    }

    public void start(){
        enableSymbols();
        initializePlayers();
    }

    private void initializePlayers(){
        for (int i = 0; i < 10; i++){
            p1.drawCard(deck);
        }
        System.out.println(p1.getHand());
        for (Card c : p1.getHand()){
            System.out.printf("%d, ", c.getValue());
        }
    }

    private void enableSymbols(){
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, StandardCharsets.UTF_8));
    }
}
