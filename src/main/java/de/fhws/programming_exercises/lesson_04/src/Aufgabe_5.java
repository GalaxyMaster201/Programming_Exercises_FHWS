package de.fhws.programming_exercises.lesson_04.src;

import java.util.Scanner;

public class Aufgabe_5{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean gueltig = false;    //EINGABE zwischen 1 und 1000000
        int eingabe = 0;
        int querprodukt = 1;

        //Die EINGABE wiederholt sich, bis der Nutzer eine gültige Zahl eingibt
        while (!gueltig){
            System.out.print("Geben Sie eine ganze Zahl zwischen 1 und 1000000 ein: ");
            eingabe = scanner.nextInt();
            gueltig = (eingabe >= 1) && (eingabe <= 1000000); //Wenn true, wird die Wiederholung abgebrochen
            if (!gueltig){
                System.out.println("\nFEHLER - Ihre Eingabe ist nicht gültig");

            }
        }

        //die letzte Ziffer der Zahl wird mit dem Produkt addiert und von der Zahl entfernt
        for (int i = eingabe; i > 0; i /= 10){
            querprodukt *= (i % 10);
        }
        //Querprodukt ausgerechnet, AUSGABE:
        System.out.println("\nDas Querprodukt der Zahl " + eingabe + " ist " + querprodukt);
        scanner.close();
    }
}
