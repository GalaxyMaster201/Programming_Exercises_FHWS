package de.fhws.programming_exercises.lesson_04.src;

public class Aufgabe_4 {
    public static void main(String[] args){
        System.out.println("Fahrenheit:\t\tCelsius:");
        for (int fahrenheit=0; fahrenheit <= 300; fahrenheit++){
            float celsius = (5f/9)*(fahrenheit-32);     //Umrechnungsformel für °F in °C
            System.out.printf("%5d\u2109",fahrenheit);    //Wert für °F ausgeben
            System.out.print("\t\t\t");     //Platz zwischen den Werten für Fahrenheit und Celsius erstellen
            System.out.printf("%6.2f\u2103%n",celsius);   //Wert für °C ausgeben
        }
    }

}

// \u2109 = ℉
// \u2103 = ℃
// \t = Tabulator