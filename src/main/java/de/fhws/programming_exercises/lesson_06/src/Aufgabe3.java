package de.fhws.programming_exercises.lesson_06.src;

import java.util.Scanner;

public class Aufgabe3{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int anzahl;
        int option;

        // EINGABE
        do{
            System.out.print("Geben Sie die Anzahl der Zeilen ein: ");
            anzahl = scanner.nextInt();
            if (anzahl <= 0){
                System.out.println("\nDie Zahl muss größer 0 sein!");
            } else{
                break;
            }
        } while (true);
        do{
            System.out.println("Welcher Art vom Dreieck möchten Sie bilden");
            System.out.println("0 - linksbündig");
            System.out.println("1 - zentriert");
            option = scanner.nextInt();
            if (option != 0 && option != 1){
                System.out.println("\nBitte wählen Sie eine der verfügbaren Optionen!");
            } else{
                break;
            }
        } while (true);

        // AUSWAHL
        if (option == 0){
            System.out.println(dreieckLinks(anzahl));
        } else{
            System.out.println(dreieckZentriert(anzahl));
        }

    }

    // linksbündiges Dreieck
    public static String dreieckLinks(int x){
        String str = "";
        for (int reihen = 1; reihen <= x; reihen++){                // Reihe ändern
            for (int spalten = 1; spalten <= reihen; spalten++){    // Spalte ändern und * schreiben
                str += "* ";
            }
            str += "\n";
        }
        return str;
    }

    // zentriertes Dreieck
    public static String dreieckZentriert(int x){
        String str = "";
        int einrueckung = x;
        for (int reihen = 1; reihen <= x; reihen++, einrueckung--){
            for (int i = 1; i < einrueckung; i++){                      // mit Leerzeichen puffern
                str += " ";
            }
            for (int spalten = 1; spalten <= reihen; spalten++){
                str += "* ";
            }
            str += "\n";
        }
        return str;
    }
}

// while(true) ist ein bisschen gefährlich, aber ist die einfachste Art um gleichzeitig eine Fehlermeldung anzuzeigen und wiederholen