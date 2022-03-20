package de.fhws.programming_exercises.lesson_03.src;

import java.util.Scanner;

public class Aufgabe_3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean grossbuchstabe = false;
        boolean hexadecimal = false;
        boolean oktal = false;
        boolean binaer = false;

        //EINGABE
        System.out.print("Bitte einen Einzelzeichen eingeben: ");
        String s = scanner.nextLine();

        char eingabe = s.charAt(0);

        //ÜBERPRÜFUNG
        if (eingabe >= 'A' && eingabe <= 'Z'){
            grossbuchstabe = true;
            if (eingabe <= 'F'){
                hexadecimal = true;
            }
        }else if (eingabe >= '0' && eingabe <= '9'){
            hexadecimal = true;
            if (eingabe <= '7'){
                oktal = true;
                if (eingabe <= '1'){
                    binaer = true;
                }
            }
        }else if (eingabe >= 'a' && eingabe <= 'f'){
            hexadecimal = true;
        }

        //AUSGABE
        if (binaer){
            System.out.println("Der Einzelzeichen "+eingabe+" ist hexadezimal, oktal und binaer.");
        }else if (oktal){
            System.out.println("Der Einzelzeichen "+eingabe+" ist hexadezimal und oktal.");
        }else if (hexadecimal && grossbuchstabe){
            System.out.println("Der Einzelzeichen "+eingabe+" ist hexadezimal und eine Großbuchstabe.");
        }else if (hexadecimal){
            System.out.println("Der Einzelzeichen "+eingabe+" ist hexadezimal.");
        }else{
            System.out.println("Der Einzelzeichen "+eingabe+" ist unbekannt.");
        }
        scanner.close();
    }
}
