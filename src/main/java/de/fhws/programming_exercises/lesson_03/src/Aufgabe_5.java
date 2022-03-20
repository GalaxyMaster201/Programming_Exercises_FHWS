package de.fhws.programming_exercises.lesson_03.src;

import java.util.Scanner;

public class Aufgabe_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Die Matrikelnummer eingeben: ");
        String eingabe = scanner.nextLine();

        //Eingabe hat an der ersten Stelle eine 5 und an der zweiten eine 0 oder 1
        boolean matrikel_51x_50x = (eingabe.charAt(0) == '5' && (eingabe.charAt(1) == '0' || eingabe.charAt(1) == '1'));
        //Eingabe hat an der ersten Stelle eine 6 und an der zweiten eine 1
        boolean matrikel_61x = (eingabe.charAt(0) == '6' && eingabe.charAt(1) == '1');

        //Die Eingabe hat 7 Stellen und fängt mit 50, 51 oder 61 an
        if (eingabe.length() == 7 && (matrikel_51x_50x || matrikel_61x)){
            System.out.println("Die Matrikelnummer "+eingabe+" ist gültig");
        }else{
            System.out.println("Die Matrikelnummer "+eingabe+" ist nicht gültig");
        }
    }
}
