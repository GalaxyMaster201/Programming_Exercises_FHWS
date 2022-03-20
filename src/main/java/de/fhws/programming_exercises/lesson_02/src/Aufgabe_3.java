package de.fhws.programming_exercises.lesson_02.src;

import java.time.LocalTime;

public class Aufgabe_3 {
    public static void main(String[] args) {

//        int stunden = 22;
//        int minuten = 37;
//        int sekunden = 36;

        LocalTime time = LocalTime.now();
        int stunden = time.getHour();
        int minuten = time.getMinute();
        int sekunden = time.getSecond();

        System.out.println("Aktuelle Uhrzeit: "+stunden+":"+minuten+":"+sekunden);
        System.out.println("Es sind "+seitMitternacht(stunden,minuten,sekunden)+" Sekunden seit Mitternacht vergangen");
        System.out.println("Bis Mitternacht sind es noch "+bisMitternacht(stunden,minuten,sekunden)+" Sekunden");
        System.out.println("Es sind schon "+prozent(seitMitternacht(stunden,minuten,sekunden))+"% des Tages vergangen");
    }
    public static int seitMitternacht(int h, int m, int s){
        return h*3600 + m*60 + s;
    }
    public static int bisMitternacht(int h, int m, int s){
        return 86400-(h*3600 + m*60 + s);
    }
    public static float prozent(int s){
        return Math.round((s/86400.0)*10000.0)/100.0f;
    }
}
