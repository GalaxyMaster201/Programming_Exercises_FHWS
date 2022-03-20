package de.fhws.programming_exercises.lesson_07.src;

import java.util.Scanner;

public class Aufgabe3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // EINGABE
        System.out.println("Geben Sie ihr Text ein: ");
        System.out.print("-> ");
        String eingabe = scanner.nextLine();

        // AUSGABE
        System.out.println(inGrossbuchstaben(eingabe));

    }

    /**
     * Wandelt alle Kleinbuchstaben in einem String in Großbuchstaben und gibt den String wieder zurück
     * @param inputStr Der vom Nutzer eingegebene Text
     * @return  String mit nur Großbuchstaben
     */
    public static String inGrossbuchstaben(String inputStr){
        StringBuilder outputStr = new StringBuilder();
        for (int i = 0; i < inputStr.length(); i++) {
            char c = inputStr.charAt(i);
            if(c >= 'a' && c <= 'z'){
                c -= 32;
            }
            outputStr.append(c);
        }
        return outputStr.toString();
    }
}
