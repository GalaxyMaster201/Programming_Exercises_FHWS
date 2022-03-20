package de.fhws.programming_exercises.lesson_04.src;

import java.util.Scanner;

public class Aufgabe_3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Geben Sie eine natürliche Zahl ein: ");
        int maxzahl = scanner.nextInt();

        boolean primzahl;
        
        if (maxzahl < 1) {
            throw new RuntimeException(maxzahl+" ist keine natürliche Zahl!");  //ungültige Eingabe → Programm abbrechen
        }

        for (int zahl = 2; zahl <= maxzahl; zahl++) {     //gehe durch alle Zahlen von 2 bis zu der eingegebenen maximalen Zahl
            primzahl = true;
            for (int i = 2; i <= Math.sqrt(zahl); i++) {    //überprüfen, ob die Zahl eine Primzahl ist,
                                                            // indem man sie durch andere Zahlen versucht ganzzahlig zu teilen
                if ((zahl % i) == 0) {
                    primzahl = false;
                    break;      //wenn die Zahl durch irgendwas teilbar ist, abbrechen (Fail-Early-Prinzip)
                }
            }
            //AUSGABE
            if (primzahl) {
                System.out.println("Die Zahl " + zahl + " ist eine Primzahl");
            } else {
                System.out.println("Die Zahl " + zahl + " ist nicht eine Primzahl");
            }
        }
        scanner.close();
    }
}
// FUN FACT: Mein PC hat es in 1 Stunde und 22 Minuten bis 579'365'199 geschafft (Ziel war 999'999'999)