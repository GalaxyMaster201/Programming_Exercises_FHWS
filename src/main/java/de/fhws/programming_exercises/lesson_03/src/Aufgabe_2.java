package de.fhws.programming_exercises.lesson_03.src;

import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

public class Aufgabe_2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.##");   //Formattierung der Ausgabe
        Locale.setDefault(new Locale("de","DE"));   //Komma statt Punkt für floats

        //EINGABE
        System.out.print("Durchmesser der ersten Pizza: ");
        int durchmesser_1 = scanner.nextInt();
        System.out.print("Preis der ersten Pizza: ");
        float preis_1 = (scanner.nextFloat());
        System.out.print("Durchmesser der zweiten Pizza: ");
        int durchmesser_2 = scanner.nextInt();
        System.out.print("Preis der zweiten Pizza: ");
        float preis_2 = scanner.nextFloat();
        ///////////////////////////////////////////////////////////////////////////////
        if (preis_1 <= 0 || preis_2 <= 0){
            System.out.println("Der Preis muss größer als 0 sein");
        }else{
            //Flächenberechnunge
            double flaeche_1 = (1d / 4) * Math.PI * Math.pow(durchmesser_1, 2);
            double flaeche_2 = (1d / 4) * Math.PI * Math.pow(durchmesser_2, 2);
            //Preis/Fläche-Verhältnis
            double verhaeltnis_1 = preis_1 / flaeche_1;
            double verhaeltnis_2 = preis_2 / flaeche_2;

            System.out.println();//spacer

            //AUSGABE
            if ((verhaeltnis_1 - verhaeltnis_2) < 0.00000000001) {      //beide Pizzen gleich
                System.out.println("Bei beiden Pizzen ist der Preis-/Flächeverhältnis gleich");
            }else if (verhaeltnis_1 < verhaeltnis_2) {     //Pizza 1 gewinnt
                System.out.println("Die erste Pizza von " + durchmesser_1 + " cm lohnt sich mehr.");
                System.out.println("Fläche: " + df.format(flaeche_1) + " Quadratzentimeter\nPreis pro Quadratzentimeter: " + df.format(verhaeltnis_1) + " Euro.");
            } else if (verhaeltnis_2 < verhaeltnis_1) {       //Pizza 2 gewinnt
                System.out.println("Die zweite Pizza von " + durchmesser_2 + " cm lohnt sich mehr.");
                System.out.println("Fläche: " + df.format(flaeche_2) + " Quadratzentimeter\nPreis pro Quadratzentimeter: " + df.format(verhaeltnis_2) + " Euro.");
            } else {
                System.out.println("Etwas ist schiefgelaufen :/");
            }
            scanner.close();
        }
    }
}
