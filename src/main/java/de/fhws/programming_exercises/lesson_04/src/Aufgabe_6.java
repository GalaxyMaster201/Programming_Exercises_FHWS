package de.fhws.programming_exercises.lesson_04.src;

public class Aufgabe_6 {
    public static void main(String[] args) {
        for (int x = 1; x <= 10; x++){  //Faktor 1
            for (int y = 1; y <= 10; y++){  //Faktor 2
                System.out.println(x+"x"+y+"="+(x*y));  //AUSGABE
            }
            System.out.println();   //Spacer
        }
    }
}