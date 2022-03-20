package de.fhws.programming_exercises.lesson_06.src;

import java.util.Scanner;

public class Aufgabe1{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int auswahl;
        // AUSWAHL
        do{
            System.out.println("Wählen Sie die Art der Rundung");
            System.out.println("0 = auf eine ganze Zahl");
            System.out.println("1 = auf eine bestimmte Anzahl Nachkommastellen");
            auswahl = scanner.nextInt();
        }while (auswahl != 0 && auswahl != 1);

        //EINGABE
        System.out.print("Geben Sie die Zahl ein: ");
        double zahl = scanner.nextDouble();

        //AUSGABE
        if (auswahl == 0){
            System.out.println(rundeAufInt(zahl));
        }else{
            System.out.print("Geben Sie die Anzahl der Nachkommastellen ein: ");
            int dezimal = scanner.nextInt();
            System.out.println(rundeAufStellen(zahl,dezimal));
        }
        scanner.close();
    }

    // rundet die Zahl auf eine ganze Zahl
    public static int rundeAufInt(double x){
        int ganzeZahl = (int) x;
        double nachkommazahl = x % 1;
        if (nachkommazahl > 0.5 || betragVon(nachkommazahl - 0.5) <= 0.000001){
            return ganzeZahl + 1;
        } else{
            return ganzeZahl;
        }
    }

    // rundet die Zahl auf eine bestimmte Anzahl Nullstellen
    public static String rundeAufStellen(double x, int stellen){
        int anzahlNachkommastellen = berechneAnzahlNachkommastellen(x);
        if (stellen < anzahlNachkommastellen ){                                 // die gewünschte Anzahl Nachkommastellen ist kleiner als die, die die Zahl schon hat
            double potenz = zehnHoch(stellen);
            double expandierteZahl = (x * potenz);                              // die Zahl wird mit 10 hoch "nachkommastellen" multipliziert 1.234 -> 123.4
            return Double.toString(rundeAufInt(expandierteZahl) / potenz);   // die Zahl wird gerundet, durch 10 hoch "nachkommastellen" geteilt und ausgegeben 123.4 -> 123 -> 1.23
        }else{                                                                  // die gewünschte Anzahl Nachkommastellen ist größer als die, die die Zahl schon hat
            String str = Double.toString(x);
            for (int i = 1; i <= (stellen-anzahlNachkommastellen); i++){
                str += "0";                                                     // mit 0 bis "stellen" ausfüllen
            }
            return str;
        }
    }

    // Weil wir die Math Bibliothek nicht nutzen dürfen:

    // rechnet 10 hoch eine Zahl
    public static int zehnHoch(int exponent){
        int res = 1;
        for (int i = 1; i <= exponent; i++){
            res *= 10.0;
        }
        return res;
    }

    // Betrag einer Zahl
    public static double betragVon(double x){
        if (x < 0){
            return x * -1;
        }else {
            return x;
        }
    }

    public static int berechneAnzahlNachkommastellen(double x){
        int res;
        String str = Double.toString(x);
        res = str.length() - str.indexOf(".") - 1;
        return res;
    }
}
