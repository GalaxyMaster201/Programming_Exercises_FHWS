package de.fhws.programming_exercises.lesson_06.src;

import java.util.Scanner;

public class Aufgabe6{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int d;
        int s1;
        int s2;

        // EINGABE
        do{
            System.out.print("Distanz: ");
            d = scanner.nextInt();
        } while (d <= 0);
        do{
            System.out.print("Sprunglänge 1: ");
            s1 = scanner.nextInt();
        } while (s1 <= 0);
        do{
            System.out.print("Sprunglänge 2: ");
            s2 = scanner.nextInt();
        } while (s2 <= 0);

        // AUSGABE
        System.out.println("Es gibt "+springeInMehrerenSpruengen(d, s1, s2)+" Möglichkeiten");

        scanner.close();
    }

    // Methode gibt die Anzahl der Möglichkeiten an
    public static int springeInMehrerenSpruengen(int distanz, int sprungEins, int sprungZwei){
        int anzahl = 0;
        for (int i = 0; i <= distanz/sprungEins; i++){                         // Faktor von sprungEins ändert sich
            for (int j = 0; j <= distanz/sprungZwei; j++){                     // Faktor von sprungZwei ändert sich
                if ((i * sprungEins)+(j * sprungZwei) == distanz){  // mögliche Lösung
                    anzahl += berechnePermutationen(i+j, Math.max(i,j));          // alle Permutationen der Lösung
                    break;
                }
            }
        }
        return anzahl;
    }

    // Berechnet die Anzahl der Permutationen mit dem Binomialkoeffizienten
    public static int berechnePermutationen(int ziffern, int wiederholungen){
        return fakVon(ziffern) / (fakVon(wiederholungen) * fakVon(ziffern-wiederholungen));    //BinKo Berechnung;
    }

    // vereinfachte Fakultätberechnung von Aufgabe2
    public static int fakVon(int x){
        int res = 1;
        for (int i = 2; i <= x; i++){
            res *= i;
        }
        return res;
    }

}
