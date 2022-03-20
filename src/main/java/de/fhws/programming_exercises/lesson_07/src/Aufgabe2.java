package de.fhws.programming_exercises.lesson_07.src;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Aufgabe2{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);   // laut einem Kommilitonen soll man den Scanner in der main-Methode "starten" und dann anderen Methoden übergeben
        double[] werteArr = holeArr(scanner);

        double mittelwert = arithmetischesMittel(werteArr);
        double[] minMaxArr = findeMinMaxWert(werteArr);

        double minWert = minMaxArr[0];
        double maxWert = minMaxArr[1];

        // AUSGABE
        System.out.printf("Mittelwert: %.3f %n", mittelwert);   // Mittelwert

        if (Math.abs((Math.round(minWert * 1000) / 1000d)-minWert) < 1E-6){
            System.out.printf("Min: %.3f %n", minWert);  // min-Wert mit Rundung
        } else{
            System.out.printf("Min: %f %n", minWert);   // min-Wert ohne Rundung
        }

        if (Math.abs((Math.round(maxWert * 1000) / 1000d)-maxWert) < 1E-6){
            System.out.printf("Max: %.3f %n", maxWert);  // max-Wert mit Rundung
        } else{
            System.out.printf("Max: %f %n", maxWert);   // max-Wert ohne Rundung
        }

        System.out.printf("Standardabweichung: %.3f %n", berechneStandardabweichung(werteArr, mittelwert)); // Standardabweichung

        scanner.close();
    }

    /**
     * Die Methode startet die Eingabeprozedur, nimmt vom Nutzer die Werte auf und speichert sie in ein Array
     *
     * @return ein double[] Array mit den eingegebenen Werten
     */
    public static double[] holeArr(Scanner scanner){
        double[] arr;
        int laenge;
        // Anzahl der einzugebenden Werten einlesen
        do{
            System.out.print("Anzahl der Werte: ");
            laenge = scanner.nextInt();
            if (laenge > 0){
                arr = new double[laenge];   // setze die Größe des Arrays
                break;
            } else{
                // ungültige Eingabe, wiederholen
                System.out.println("Ihre Eingabe ist ungültig, die Zahl muss größer 0 sein");
            }
        } while (true);

        // Eingabe der einzelnen Werten
        System.out.println("Geben Sie jetzt Ihre Werte ein ");
        for (int i = 0; i < laenge; i++){
            System.out.print("Wert "+(i+1)+": ");
            try{
                arr[i] = scanner.nextDouble();  // schreibe den Wert ins Array
            } catch (InputMismatchException e){
                // ungültige Eingabe, mit Fehlermeldung Programm terminieren
                throw new NumberFormatException("FEHLER: Die Eingabe ist keine Zahl");
            }
        }
        return arr;
    }

    /**
     * Berechnet das arithmetische Mittel der Werte in einem Array
     *
     * @param arr Array mit beliebig vielen numerischen Werten
     * @return berechneter Mittelwert
     */
    public static double arithmetischesMittel(double[] arr){
        double res = 0;
        for (int i = 0; i < arr.length; i++){
            res += arr[i]; // addiere alle Elemente des Arrays zusammen
        }
        res /= arr.length;  // Mittelwert berechnen
        return res;
    }

    /**
     * Findet den kleinsten und größten Wert in einem Array
     *
     * @param arr Array mit beliebig vielen numerischen Werten
     * @return ein zusätzliches Array mit dem min-Wert an der Stelle 0 und max-Wert an der Stelle 1
     */
    public static double[] findeMinMaxWert(double[] arr){
        double maxZahl = arr[0];
        double minZahl = arr[0];
        // findet den kleinsten Wert in einem Array, indem die Schleife durch alle Zahlen geht
        // und immer den kleinsten Wert speichert
        for (int i = 1; i < arr.length; i++){
            if (minZahl > arr[i]){
                minZahl = arr[i];
            }
        }
        // findet den größten Wert in einem Array indem die Schleife durch alle Zahlen geht
        // und immer den größten Wert speichert
        for (int i = 1; i < arr.length; i++){
            if (maxZahl < arr[i]){
                maxZahl = arr[i];
            }
        }
        // gibt ein zweistelliges Array mit dem kleinsten ud größten Wert zurück
        return new double[]{minZahl, maxZahl};
    }

    /**
     * Berechnet die Standartabweichung des Arrays
     *
     * @param arr        Array mit den eingegebenen Werten
     * @param mittelwert arithmetisches Mittel des Arrays
     * @return berechneter Wert für die Standardabweichung
     */
    public static double berechneStandardabweichung(double[] arr, double mittelwert){
        double res = 0;
        for (int n = 0; n < arr.length; n++){
            res += Math.pow(arr[n]-mittelwert, 2);   //berechnet die Reihe
        }
        res = Math.sqrt((1d / arr.length) * res);
        return res;
    }
}
