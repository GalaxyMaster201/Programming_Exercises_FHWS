package de.fhws.programming_exercises.lesson_03.src;

import java.util.Scanner;

public class Aufgabe_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //RuntimeException initialisieren
        class fehler extends RuntimeException{
            public fehler(String errorMessage){
                super(errorMessage);
            }
        }
        //EINGABE
        System.out.print("Erstes Zeichen als t oder f eingeben: ");
        char zeichen_1 = scanner.nextLine().charAt(0); //char-Extraktion
        System.out.print("Zweites Zeichen als t oder f eingeben: ");
        char zeichen_2 = scanner.nextLine().charAt(0);

        boolean zeichen_1_bool; //zeichen_1 als boolean gespeichert
        boolean zeichen_2_bool; //zeichen_2 als boolean gespeichert

            if (zeichen_1 == 't') {
                zeichen_1_bool = true;
            } else if (zeichen_1 == 'f') {
                zeichen_1_bool = false;
            } else {
                throw new fehler("Zeichen muss entweder t oder f sein");
            }

            if (zeichen_2 == 't') {
                zeichen_2_bool = true;
            } else if (zeichen_2 == 'f') {
                zeichen_2_bool = false;
            } else {
                throw new fehler("Zeichen muss entweder t oder f sein");
            }

        System.out.println();   //Spacer

        //AUSGABE
        if (!zeichen_1_bool && !zeichen_2_bool){
            System.out.println("Ausgabe: 0");
        }else if (!zeichen_1_bool && zeichen_2_bool){
            System.out.println("Ausgabe: 1");
        }else if (zeichen_1_bool && !zeichen_2_bool){
            System.out.println("Ausgabe: 2");
        }else if (zeichen_1_bool && zeichen_2_bool){
            System.out.println("Ausgabe: 3");
        }
        scanner.close();
    }
}































