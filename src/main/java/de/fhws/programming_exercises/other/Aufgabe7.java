package de.fhws.programming_exercises.other;

public class Aufgabe7{
    public static void main(String[] args){
        natWurzel(20);
    }

    public static void natWurzel(int x){
        int summe = 0;
        int summand = 1;
        int zaehler = 0;
        while ( summe < x){
            summe+= summand;
            summand+=2;
            zaehler++;
        }
        int ergebnis = zaehler;
        System.out.println(ergebnis);

    }
}
