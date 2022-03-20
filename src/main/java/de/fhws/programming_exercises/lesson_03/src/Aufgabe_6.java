package de.fhws.programming_exercises.lesson_03.src;

import java.util.Scanner;

public class Aufgabe_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //EINGABE
        System.out.print("Bitte das Jahr eingeben: ");
        int jahr = scanner.nextInt();
        //BEDINGUNGEN
        boolean schaltjahr = ((jahr % 4 == 0) && !(jahr % 100 == 0)) || jahr % 400 == 0;
        //AUSGABE
        if (schaltjahr){
            System.out.println("Das Jahr "+jahr+" ist ein Schaltjahr");
        }else {
            System.out.println("Das Jahr "+jahr+" ist kein Schaltjahr");
        }
        scanner.close();
    }
}
