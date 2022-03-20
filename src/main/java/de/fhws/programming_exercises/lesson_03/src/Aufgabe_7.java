package de.fhws.programming_exercises.lesson_03.src;

import java.util.Scanner;

public class Aufgabe_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //EINGABE
        System.out.print("Stunden: ");
        int stunden = scanner.nextInt();
        System.out.print("Minuten: ");
        int minuten = scanner.nextInt();
        System.out.print("Sekunden: ");
        int sekunden = scanner.nextInt();

        //BEDINGUNGEN
        boolean stunden_ok = stunden >= 0 && stunden < 24;
        boolean minuten_ok = minuten >= 0 && minuten < 60;
        boolean sekunden_ok = sekunden >= 0 && sekunden < 60;

        //AUSGABE
        if (stunden_ok && minuten_ok && sekunden_ok){
            System.out.println("\nDie Uhrzeit "+stunden+":"+minuten+":"+sekunden+" ist gültig");
        }else{
            System.out.println("\nDie Uhrzeit "+stunden+":"+minuten+":"+sekunden+" ist nicht gültig");
        }
        scanner.close();
    }
}
