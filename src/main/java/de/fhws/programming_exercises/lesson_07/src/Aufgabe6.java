package de.fhws.programming_exercises.lesson_07.src;

import java.util.Arrays;

public class Aufgabe6{
    public static void main(String[] args){
        // AUSGABE
        System.out.println("Hier sind die Lottozahlen für heute: ");

        int[] zahlenArr = erzeugeZahlen();
        System.out.printf("Unsortiert: \t%s%n", Arrays.toString(zahlenArr));
        System.out.printf("Min-Sort: \t\t%s%n", Arrays.toString(sortiereZahlenMin(zahlenArr)));
        System.out.printf("Bubble-Sort: \t%s%n", Arrays.toString(sortiereZahlenBubble(zahlenArr)));
    }

    /**
     * Erzeugt pseudorandomisierte Zahlen zwischen 1 und groessteZahl (für Lotto 49)
     *
     * @return ein Array von groesse (bei Lotto 6) unterschiedlichen unsortierten pseudorandomisierten Zahlen
     */
    public static int[] erzeugeZahlen(){
        int groesse = 4;               // Größe des Zahlenarrays
        int groessteZahl = 4;         // Größte Zahl im Zahlenarray

        /*
        wenn man die Sorting-Algorithmen mit mehr Zahlen ausprobieren will,
        muss groessteZahl MINDESTENS um 1 größer als groesse sein,
        aber umso größer groessteZahl ist, desto schneller geht es (weil Array keine Duplikaten haben darf)
        */

        int[] zahlenArr = new int[groesse];
        boolean doppelt;

        do{
            doppelt = false;

            for (int i = 0; i < groesse; i++){
                // erzeugt zufällige Zahlen und speichert sie in einen Array
                zahlenArr[i] = (int) ((Math.round(Math.random() * (groessteZahl)) % (groessteZahl))+1);
            }

            // prüfe nach doppelten Werten
            for (int i = 0; i < groesse; i++){

                for (int j = i+1; j < groesse; j++){

                    if (zahlenArr[i] == zahlenArr[j]){
                        doppelt = true;
                        break;
                    }
                }
            }
        } while (doppelt);
        return zahlenArr;
    }

    /**
     * Sortiert die Elemente des Arrays mit einem Min-Sort Algorithmus
     *
     * @param zahlenArr ein unsortierter Array mit Zahlen
     * @return sortierter Array
     */
    public static int[] sortiereZahlenMin(int[] zahlenArr){
        boolean sortiert = false;

        for (int linkesElement = 0; linkesElement < zahlenArr.length || !sortiert; linkesElement++){
            int indexKleinsteZahl;                                                                              //index der kleinsten Zahl ab linkesElement

            for (int rechtesElement = linkesElement; rechtesElement < zahlenArr.length; rechtesElement++){

                if (zahlenArr[linkesElement] > zahlenArr[rechtesElement]){

                    indexKleinsteZahl = linkesElement;
                    int temp = zahlenArr[linkesElement];

                    if (zahlenArr[indexKleinsteZahl] > zahlenArr[rechtesElement]){      // schiebt den kleinsten Wert nach links und nimmt sein Platz
                        zahlenArr[indexKleinsteZahl] = zahlenArr[rechtesElement];
                    }
                    zahlenArr[rechtesElement] = temp;
                }
            }

            // prüfe ob Array sortiert ist
            for (int j = 0; j < zahlenArr.length-1; j++){

                if (zahlenArr[j] < zahlenArr[j+1]){
                    sortiert = true;
                } else{
                    sortiert = false;
                    break;
                }
            }
        }
        return zahlenArr;
    }

    // Ich habe erstens nicht gemerkt, dass man den Algorithmus aus dem Video nehmen muss.
    // Hier ist meine Version von einem Algorithmus, der mindestens ähnlich dem Bubble-Sort ist.

    /**
     * Sortiert die Elemente des Arrays mit einem (fast) Bubble-Sort Algorithmus
     *
     * @param zahlenArr ein unsortierter Array mit Zahlen
     * @return sortierter Array
     */
    public static int[] sortiereZahlenBubble(int[] zahlenArr){
        int temp;
        boolean sortiert = false;
        do{
            // tausche 2 Zahlen, wenn der erste größer als der zweite ist
            for (int i = 0; i < zahlenArr.length-1; i++){
                if (zahlenArr[i] > zahlenArr[i+1]){
                    temp = zahlenArr[i];
                    zahlenArr[i] = zahlenArr[i+1];
                    zahlenArr[i+1] = temp;
                }
            }
            // prüfe ob der Array sortiert ist
            for (int j = 0; j < zahlenArr.length-1; j++){
                if (zahlenArr[j] < zahlenArr[j+1]){
                    sortiert = true;
                } else{
                    sortiert = false;   // unsortiert, wiederholen
                    break;
                }
            }
        } while (!sortiert);
        return zahlenArr;
    }
}
