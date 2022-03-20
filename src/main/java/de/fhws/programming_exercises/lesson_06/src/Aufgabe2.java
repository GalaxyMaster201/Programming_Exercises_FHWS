package de.fhws.programming_exercises.lesson_06.src;

import java.util.Scanner;

public class Aufgabe2{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        // EINGABE
        System.out.print("Von welcher Zahl möchten Sie die Fakultät wissen?\n: ");
        int eingabe = scanner.nextInt();

        // AUSGABE
        // bei Zahlen über 170 kommt Infinity vor, da die Zahlen einfach zu groß sind
        if (eingabe > 170){
            System.out.println("Die Fakultät dieser Zahl kann mit diesem Programm nicht ausgerechnet werden :(");
            System.out.println("Dazu empfehle ich DrRacket.");
        } else{
            System.out.println("Die Fakultät von "+eingabe+" ist: "+fakVon(eingabe));
        }
        scanner.close();
    }

    // berechnet die Fakultät einer Zahl
    public static String fakVon(int x){
        if (x >= 20){       // für große Zahlen als Double mit der wissenschaftlichen Schreibweise ausgeben
            double res = 1;
            for (int i = 2; i <= x; i++){
                res *= i;
            }
            return Double.toString(res);
        }else{              // für kleinere Zahlen als Integer ausgeben
            int res = 1;
            for (int i = 2; i <= x; i++){
                res *= i;
            }
            return Integer.toString(res);
        }

    }
}

// für kleinere Zahlen kann die Ausgabe ein Integer sein, für größere ein Long und für noch größere ein Double
// eine Alternative für unendlich große Zahlen wäre vielleicht, dass man mit der BigInteger Klasse rechnet, aber sie ist ein Teil der Math Bibliothek


