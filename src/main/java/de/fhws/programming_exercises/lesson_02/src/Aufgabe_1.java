package de.fhws.programming_exercises.lesson_02.src;

public class Aufgabe_1 {
    public static void main(String[] args){
        final double PI = Math.PI; //pi als Konstante einfügen
        int r = 5;
        //Alle Größen berechnen und runden
        double Umfang = Math.round((2*r*PI)*1000.0)/1000.0;
        double Flaeche = Math.round((PI*(r*r))*1000.0)/1000.0;
        double Volumen = Math.round(((4.0/3)*PI*(r*r*r))*1000.0)/1000.0;

        System.out.println("Der Umfang eines Kreises mit dem Radius "+r+" LE ist "+Umfang+" LE");
        System.out.println("Die Fläche eines Kreises mit dem Radius "+r+" LE ist "+Flaeche+" FE");
        System.out.println("Das Volumen einer Kugel mit dem Radius "+r+" LE ist "+Volumen+" VE");
    }
}
