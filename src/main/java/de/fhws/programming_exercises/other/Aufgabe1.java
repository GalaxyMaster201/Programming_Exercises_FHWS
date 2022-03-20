package de.fhws.programming_exercises.other;
import java.util.Arrays;

public class Aufgabe1{
    private static char[] ausgabe;
    public static void main (String[] args){
        String eingabeString = "Graphik.Init.Datei.ini";
        ersetze(eingabeString.toCharArray());

        // die Methode println(char[] x) von der PrintStream Klasse
        // gibt die einzelne Chars in Form eines Textes aus
        System.out.println(ausgabe);
    }

    public static int ersetze(char[] eingabe){
        int erweiterungStart = 0;

        // finde den Index der Erweiterung
        for (int i = eingabe.length-1; i >=0 ; i--){
            if (eingabe[i] == '.'){
                erweiterungStart = i;
                break;
            }
        }

        int zaehler = 0;
        // ersetze alle andere Punkte
        for (int i = 0; i < erweiterungStart; i++){
            if (eingabe[i] == '.'){
                eingabe[i] = '_';
                zaehler++;
            }
        }
        ausgabe = Arrays.copyOf(eingabe, eingabe.length);
        return zaehler;
    }
}