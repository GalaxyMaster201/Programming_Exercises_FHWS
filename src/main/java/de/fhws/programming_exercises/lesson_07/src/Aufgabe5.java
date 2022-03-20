package de.fhws.programming_exercises.lesson_07.src;

public class Aufgabe5{
    public static void main(String[] args){
        int euroInSchreibtisch = 0;             // Wie oft war die Münze in der letzten Schublade
        int versuche = 10000;                   // Anzahl der Versuche
        for (int i = 0; i < versuche; i++){
            if (randomBool()){
                euroInSchreibtisch++;
            }
        }
        double wahrscheinlichkeit = 0.5;                            // Es gibt eine 50 % Chance, dass die Münze in einer der Schubladen liegt.
        wahrscheinlichkeit -= 1 / 3d * wahrscheinlichkeit;          // Bei jeder leeren Schublade sinkt die Chance um weitere 33,3333 % von den 50 % (also um 16.6666%)
        wahrscheinlichkeit -= euroInSchreibtisch / (versuche*3d);

        System.out.println("Die Chance, dass die Münze in der dritten Schublade liegt, wenn die ersten zwei leer waren ist: ");
        System.out.printf("%.4f %s",Math.round(wahrscheinlichkeit*1000000)/10000d,"%");
    }

    /**
     * Erzeugt einen randomisierten Boolean.
     * Bestimmt, ob sich die Münze in der letzten Schublade befindet
     *
     * @return ist die Münze in der letzten Schublade oder nicht
     */
    public static boolean randomBool(){
        long cond = Math.round(Math.random());
        return cond == 1;
    }
}



