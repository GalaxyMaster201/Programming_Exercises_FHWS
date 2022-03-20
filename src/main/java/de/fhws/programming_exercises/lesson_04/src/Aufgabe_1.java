package de.fhws.programming_exercises.lesson_04.src;

public class Aufgabe_1 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Countdown:");
        for(int i=15;i>0;i--){
            System.out.println("T-"+i);
            Thread.sleep(1000); //warte 1 Sekunde
        }
        System.out.println("LIFTOFF!");
    }
}
