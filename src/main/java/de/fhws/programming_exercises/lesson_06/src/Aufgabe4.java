package de.fhws.programming_exercises.lesson_06.src;

import java.util.Scanner;

public class Aufgabe4{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int zahl;
        // EINGABE
        // EINGABE
        do{
            System.out.print("Geben Sie eine natürliche Zahl ein: ");
             zahl = scanner.nextInt();
             // ungültige Eingabe
             if(zahl < 2){
                 System.out.println("\nIhre Eingabe ist ungültig, die zahl muss größer 2 sein.");
             }else{
                 break;
             }
        }while (true);

        // AUSGABE
        if (primzahl(zahl)){
            System.out.println("Die Zahl "+zahl+" ist eine Primzahl.");
        } else{
            System.out.println("Die Zahl "+zahl+" ist keine Primzahl.");
        }
        scanner.close();
    }

    // testet, ob die Zahl eine Primzahl ist und ergibt ein true oder false
    public static boolean primzahl(int zahl){
        boolean primzahl;

        primzahl = true;
        for (int i = 2; i <= Math.sqrt(zahl); i++){     //überprüfen, ob die Zahl eine Primzahl ist,
                                                        // indem man sie durch andere Zahlen versucht ganzzahlig zu teilen
            if ((zahl % i) == 0){
                primzahl = false;
                break;                                  //wenn die Zahl durch irgendwas teilbar ist, abbrechen (Fail-Early-Prinzip)
            }
        }
        return primzahl;
    }
}