package de.fhws.programming_exercises.lesson_05.src;

public class Aufgabe1 {
    public static void main(String[] args) {
        int k = 1;
        double summeAlt;
        double summeNeu = 0;

        do{
            summeAlt = summeNeu;
            summeNeu = summeAlt + (1f/Math.pow(k,2));   // neue Summe berechnen
            System.out.printf("%8.5f%n",6 * summeNeu);      // Summe mit 6 multiplizieren und ausgeben
            k++;    // k vergrößern

        }while ((summeNeu-summeAlt) >= 0.00001);    // Unterschied zwischen der alten und neuen Summe berechnen


    }
}

// a) 1; 0,25; 0,111; 0,0625; 0,04
// c) Mathematisch macht es keinen Unterschied (Distributivgesetz). Im Code könnte die Berechnung ein wenig länger dauern,
//    da mehr Rechenoperationen durchgeführt werden müssen. (vernachlässigbar)
