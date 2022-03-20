package de.fhws.programming_exercises.lesson_03.src;

public class Aufgabe_4 {
    public static void main(String[] args) {
        int zahl = (int) Math.round(((Math.random() * 5)) + 1);
        ////////////////ERKLÄRUNG/////////////////////
        /*
        Math.random produziert eine Kommazahl in [0,1).
        Die Zahl wird multipliziert und gerundet, um eine Zahl in [0,5] zu bekommen.
        Mit dem + 1 kreiegen wir am Ende unser Ergebnis: [1,6]
         */
        if (zahl == 1) {
            System.out.println("Du hast eine eins (1) gewürfelt");
        } else if (zahl == 2) {
            System.out.println("Du hast eine zwei (2) gewürfelt");
        } else if (zahl == 3) {
            System.out.println("Du hast eine drei (3) gewürfelt");
        } else if (zahl == 4) {
            System.out.println("Du hast eine vier (4) gewürfelt");
        } else if (zahl == 5) {
            System.out.println("Du hast eine fünf (5) gewürfelt");
        } else if (zahl == 6) {
            System.out.println("Du hast eine sechs (6) gewürfelt");
        }
    }
}
