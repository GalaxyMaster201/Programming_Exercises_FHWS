package de.fhws.programming_exercises.lesson_06.src;

import java.util.Scanner;

public class Aufgabe5{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        // EINGABE
        System.out.print("Geben Sie die Basis ein: ");
        int basis = scanner.nextInt();
        System.out.print("Geben Sie den Exponenten ein: ");
        int exponent = scanner.nextInt();

        double res = rekursivePotenz(basis,Math.abs(exponent),1);
        // AUSGABE
        if(exponent < 0){
            System.out.println(1/res);
        }else {
            System.out.println(res);
        }
        scanner.close();
    }
    // Methode berechnet die Potenz rekursiv
    public static double rekursivePotenz(int basis, int exp, double res){
        if (exp != 0){
            res = rekursivePotenz(basis, --exp, res * basis); // REKURSION
        }
        return res;
    }
}
