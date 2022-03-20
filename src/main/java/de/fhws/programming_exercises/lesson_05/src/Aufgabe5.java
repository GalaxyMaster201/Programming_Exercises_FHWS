package de.fhws.programming_exercises.lesson_05.src;

import java.util.Scanner;

public class Aufgabe5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Geben Sie die Anzahl der Rechtecken mit der Sie pi berechnen möchten: ");
        int anzahl = scanner.nextInt();
        double res = 0;
        final double b = 1d/anzahl;     // Breite eines Rechtecks
        double h = 1;                   // Höhe eines Rechtecks
        double x;                       // Gesamtbreite

        for (int i = 1; i <= anzahl; i++){
            res += (b * h); // Fläche zum "res" addieren
            x = b * i;  // Gesamtbreite vom Ursprung berechnen
            h = Math.sqrt(1-(x*x)); // Höhe vom nächsten Rechteck berechnen
        }

        System.out.printf("\nUnsere Berechnung von pi: %f%n", (4 * res));
        System.out.printf("Wert von pi: %f%n",Math.PI);
        System.out.printf("Unterschied: %.10f%n",Math.abs(Math.PI-(4 * res)));
    }

}
