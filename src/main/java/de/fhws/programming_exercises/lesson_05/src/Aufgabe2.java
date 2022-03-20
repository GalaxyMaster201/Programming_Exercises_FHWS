package de.fhws.programming_exercises.lesson_05.src;

import java.util.Scanner;

public class Aufgabe2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // EINGABE
        System.out.print("Geben Sie die Basis ein: ");
        double b = scanner.nextDouble();
        System.out.print("Geben Sie den Exponent ein: ");
        int n = scanner.nextInt();

        double res = 1;

        if(n > 0){      // Exponent ist positiv
            res = getRes(b, n, res,false);
        }else if(n < 0){    // Exponent ist negativ
            res = 1/getRes(b, n, res,true);
        }
        // AUSGABE
        System.out.print(b+" hoch "+n+" ist: "+res);

        scanner.close();
    }

    // Methode zur Berechnung von "res"
    private static double getRes(double b, int n, double res, boolean expNegativ) {
        int faktor = 1;
        if (expNegativ){    // beachte negative Exponenten
            faktor = -1;
        }

        // multipliziere "res" mit "b" "n"-Mal
        for (int i = 1; i <= (n*faktor); i++) {
            res *= b;
        }

        return res;
    }
}
