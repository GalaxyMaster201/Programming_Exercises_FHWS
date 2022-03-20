package de.fhws.programming_exercises.lesson_11.src.exercise_4;


public class exercise4Main{
    public static void main(String[] args){
        Ticker ticker1 = new Ticker(45);

        String str = "Wettervorhersage: Schnee in Wuerzburg";

        ticker1.setBuffer(str.toCharArray());       // set ticker message
        System.out.println(ticker1.getBuffer());

        ticker1.rotateMessage(14);          // rotate the ticker
        System.out.println(ticker1.getBuffer());
    }
}
