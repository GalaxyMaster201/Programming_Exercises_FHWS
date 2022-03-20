package de.fhws.programming_exercises.lesson_05.src;

import java.util.Scanner;

public class Aufgabe4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double naeherungswert = 1;
        int iterationen = 10;
        // EINGABE
        System.out.print("Geben Sie eine Zahl ein: ");
        double eingabe = scanner.nextDouble();


        if (eingabe > 1) {
            // nähere dich der Wurzel iterationen-Mal
            for (int i = 1; i <= iterationen; i++) {
                naeherungswert = (naeherungswert + (eingabe / naeherungswert)) / 2;
            }

            // AUSGABE
            System.out.printf("a) Die Wurzel von " + eingabe + " ist %.10f%n%n", naeherungswert);
            System.out.printf("b) Wert von Math.sqrt: %.10f%n", Math.sqrt(eingabe));
            System.out.printf("Unterschied: %.10f%n", Math.abs(Math.sqrt(eingabe) - naeherungswert));

        } else if (eingabe == 0 || eingabe == 1) {
            System.out.println("Die Wurzel von " + eingabe + " ist " + eingabe); // AUSGABE für "einfache" Zahlen
        } else {
            System.out.println("Wurzel einer negativen Zahl existiert nicht!"); // AUSGABE für negative Zahlen
        }
        scanner.close();
    }
}

// b) die Anzahl der iterationen erhöht die Genauigkeit der Berechnung, vor allem bei großen Zahlen