package de.fhws.programming_exercises.lesson_03.src;

import java.util.Scanner;

public class Aufgabe_1 {
    public static void main(String[] args){
        System.out.print("Geben Sie eine Zahl ein: ");
        Scanner scanner = new Scanner(System.in);
        int zahl = scanner.nextInt();
        int rest = zahl % 7;
        int quotient = zahl/7;
        if (rest == 0){
            System.out.println("Die Zahl "+zahl+" ist durch 7 ganzzählig teilbar.");
        }else{
            System.out.println("Die Zahl "+zahl+" ist durch 7 NICHT ganzzählig teilbar.");
        }
        System.out.println("Quotient: "+quotient+"\nRest: "+rest);
        scanner.close();
    }
}
