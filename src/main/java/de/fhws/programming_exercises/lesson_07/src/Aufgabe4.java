package de.fhws.programming_exercises.lesson_07.src;

import java.util.Scanner;

public class Aufgabe4{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        // EINGABE
        System.out.println("Geben Sie Ihr text ein: ");
        String str = scanner.nextLine();
        char[] eingabe = str.toCharArray();
        // AUSGABE
        System.out.println(String.valueOf(spielen(eingabe)));
    }

    /**
     * Startet das b-Spiel
     *
     * @param eingabe Eingabe-Array
     * @return Fertige Ausgabe
     */
    public static char[] spielen(char[] eingabe){
        int anzahlVokale = berechneAnzahlVokale(eingabe);
        char[] ausgabe = new char[eingabe.length+(anzahlVokale * 2)];               // Ausgabe-Array um die doppelte Anzahl vokalen erweitern, um "Platz zu machen"
        System.arraycopy(eingabe, 0, ausgabe, 0, eingabe.length);    // Eingabe-Array in Ausgabe-Array kopieren
        ausgabe = zeichenVerschieben(eingabe, ausgabe, anzahlVokale);                 // verschiebe die Zeichen nach rechts
        ausgabe = setzeB(ausgabe, anzahlVokale);                                     // setze b nach den Vokalen und wiederhole das Vokal

        return ausgabe;
    }

    /**
     * Verschiebt die Zeichen im Ausgang-Array, sodass rechts von jedem Vokal 2 "freie" Stellen bleiben
     *
     * @param eingabe      Eingabe-Array
     * @param ausgabe      Erweiterter Ausgabe-Array
     * @param anzahlVokale Anzahl der Vokalen im Eingabe-Array
     * @return Ausgabe-Array mit verschobenen Zeichen
     */
    public static char[] zeichenVerschieben(char[] eingabe, char[] ausgabe, int anzahlVokale){
        int[] vokalIndexArr = findeVokale(eingabe, anzahlVokale);
        int verschiebung = anzahlVokale * 2;
        int index = anzahlVokale-1;
        // verschiebt die Zeichen rechts vom Vokal um weitere 2 Stellen nach rechts
        for (int element = eingabe.length-1; element >= 0; element--){
            //int vokalIndex = vokalIndexArr[index];
            if (index > 0){
                if (element == vokalIndexArr[index]){     // Verschiebung um 2 Stellen vom NÄCHSTEN vokal
                    if (element-1 != vokalIndexArr[index-1]){
                        verschiebung -= 2;
                    }
                    index--;
                }
            }
            ausgabe[element+verschiebung] = ausgabe[element];
        }
        return ausgabe;
    }

    /**
     * Setzt ein b nach jedem Vokal und wiederholt diesen danach
     *
     * @param ausgabe      Ausgabe-Array mit verschobenen Zeichen
     * @param anzahlVokale Anzahl der Vokalen im Eingabe-Array
     * @return fertige Ausgabe mit b's und wiederholten Vokalen
     */
    public static char[] setzeB(char[] ausgabe, int anzahlVokale){
        int[] ausgabeIndex = findeVokale(ausgabe, anzahlVokale);
        int index = anzahlVokale-1;
        for (int element = ausgabe.length-1; element >= 0; element--){
            int vokalIndex = ausgabeIndex[index];
            if (element == vokalIndex){
                ausgabe[element+1] = 'b';               // setzt ein 'b' nach dem Vokal
                ausgabe[element+2] = ausgabe[element];  // wiederholt den Vokal nach dem 'b'
                if (index > 0){
                    index--;
                }
            }
        }
        return ausgabe;
    }

    /**
     * Findet die Vokale in einem Array und schreibt ihre Indices auf
     *
     * @param arr          Array, der nach Vokalen untersucht wird
     * @param anzahlVokale Anzahl der Vokalen im Eingabe-Array
     * @return Array mit Indices der Vokalen
     */
    public static int[] findeVokale(char[] arr, int anzahlVokale){
        char[] vokale = {'a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'};  // Vokalelite
        int[] vokalIndex = new int[anzahlVokale];   // deklariere den Array mit Indices
        int arrIndex = 0;
        // läuft durch den Array und speichert die Indices der Vokalen
        for (int i = 0; i < arr.length; i++){
            for (int v = 0; v < 10; v++){
                if (arr[i] == vokale[v]){
                    vokalIndex[arrIndex] = i;   // schreibt den Index eines Vokals in der Eingabe in den vokalIndex-Array
                    if (arrIndex < anzahlVokale-1){
                        arrIndex++;
                    }
                    //break;  // es können nicht 2 Vokale an einer Stelle sein :/
                }
            }
        }
        return vokalIndex;
    }

    /**
     * Berechnet die Anzahl Vokalen in dem Eingabe-Array
     *
     * @param eingabe Eingabe-Array
     * @return Anzahl der Vokalen
     */
    public static int berechneAnzahlVokale(char[] eingabe){
        char[] vokale = {'a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'};          // Array mit allen Vokalen zum Vergleich
        int anzahl = 0;
        // gehe durch die Eingabe und zähle die Vokalen
        for (int i = 0; i < eingabe.length; i++){
            for (int v = 0; v < 10; v++){                    // laufe durch den Vokalen-Array
                if (eingabe[i] == vokale[v]){               // und vergleiche
                    anzahl++;
                }
            }
        }
        return anzahl;
    }
}
// Ich habe 4 Stunden mit dieser Aufgabe verbracht und habe versucht, die setzeB Methode zu reparieren.
// Das Problem war der if in Zeile 92 bzw. der Mangel an einem if, aber jetzt funktioniert es :)
// Debug-Zeit ist invers proportional zu der Problemgröße
