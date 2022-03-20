package de.fhws.programming_exercises.lesson_04.src;

import java.util.Scanner;

public class Aufgabe_2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        final double G = 9.80665;   //Fallbeschleunigung

        System.out.print("Geben Sie die Falldauer in ganzen Sekunden an: ");
        int zeit = scanner.nextInt();   //Falldauer vom Nutzer einlesen

        for(int i=1; i<=zeit; i+=5) {   //Strecke nach der ersten und dann jeder fünften Sekunde
            System.out.println("Zeit: " + i + " Sekunde(n)");
            System.out.printf("Strecke: %10.3f meter",((1f / 2) * G * Math.pow(i, 2))); //Strecke berechnen und formatiert ausgeben
            System.out.println();
        }
        scanner.close();
    }
}
