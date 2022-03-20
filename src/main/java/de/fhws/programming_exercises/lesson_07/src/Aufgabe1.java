package de.fhws.programming_exercises.lesson_07.src;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Aufgabe1{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.######");

        // EINGABE
        System.out.println("Von welcher Zahl möchten Sie den Sinus berechnen?");
        System.out.print("x = ");
        double eingabe = scanner.nextDouble();
        if (eingabe > 37){  // bei Zahlen ab 38 erzeugt die Methode Zahlen die nicht innerhalb [-1,1] liegen (Double-Overflow?)
            System.out.println("Bei Zahlen über 37 können Probleme auftreten!");
        }

        // AUSGABE
        System.out.println("sin("+eingabe+") = "+df.format(sin(eingabe)));
        scanner.close();
    }

    /**
     * Berechnet den annähernden Wert für den Sinus einer Zahl x
     *
     * @param x Der Wert, für welchen der Sinus berechnet werden soll
     * @return Der Sinuswert von x
     */
    public static double sin(double x){
        double summe = 0;
        double summand = x;

        // berechnet die Reihe mit der angegebenen Formel
        for (int k = 0; betragVon(summand) > (1E-15); k++){
            int var = ((2 * k)+1);
            summand = (pow((-1), k) * (pow(x, var) / fakultaetVon(var))); // ein Summand der Reihe
            summe += summand;
        }
        return summe;
    }

    /**
     * Berechnet die n-te Potenz von b, in diesem Fall ist das -1^k bzw. x^((2*k)+1)
     *
     * @param b die Basis der Potenzrechnung
     * @param n der Exponent der Potenzrechnung
     * @return die potenzierte Zahl
     */
    public static double pow(double b, int n){
        double res = 1;
        for (int i = 1; i <= n; i++){
            res *= b;
        }
        return res;
    }

    /**
     * Berechnet die Fakultät einer Zahl
     *
     * @param x die Eingabe
     * @return die Fakultät
     */
    public static double fakultaetVon(int x){
        double res = 1;
        for (int i = 1; i <= x; i++){
            res *= i;
        }
        return res;
    }

    /**
     * Berechnet den Betrag einer Zahl
     *
     * @param x Eine positive oder negative Eingabe
     * @return Die Zahl x mit positivem Vorzeichen
     */
    public static double betragVon(double x){
        if (x < 0){
            return x * -1;
        } else{
            return x;
        }
    }
}
// Erste 5 Summanden: