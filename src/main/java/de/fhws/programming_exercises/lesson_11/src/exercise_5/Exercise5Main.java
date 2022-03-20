package de.fhws.programming_exercises.lesson_11.src.exercise_5;

import java.util.Scanner;

public class Exercise5Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        boolean wiederholen = false;
        int tagesanzahl = 0;

        do{
            try{
                System.out.println("Geben Sie den Monatsnamen ein: ");
                tagesanzahl = tageImMonat(scanner.nextLine());
            } catch (RuntimeException exception){
                System.out.println("Ungültige Eingabe, versuchen Sie noch einmal.");    // Exception fangen und die Eingabe wiederholen lassen
                wiederholen = true;
            }
        } while (wiederholen);

        System.out.println(tagesanzahl);
        scanner.close();
    }

    public static int tageImMonat(String monat){
        int tage;
        switch (monat){
            case "Februar":
                tage = 28;
                break;
            case "April":
            case "Juni":
            case "September":
            case "November":
                tage = 30;
                break;
            case "Januar":
            case "März":
            case "Mai":
            case "Juli":
            case "August":
            case "Oktober":
            case "Dezember":
                tage = 31;
                break;
            default:
                throw new RuntimeException("falscher Monatsname");
        }
        return tage;
    }

}
