package de.fhws.programming_exercises.other.uebungsaufgabe;

public class Kaffeetasse{
    private final int fuellmenge;
    private final int jahr;
    private final double preis;
    public Kaffeetasse next;

    private static int gesamtanzahl = 0;

    public Kaffeetasse(int fuellmenge, int jahr, double preis){
        this.fuellmenge = fuellmenge;
        this.jahr = jahr;
        this.preis = preis;
        gesamtanzahl++;
    }

    public double getPreis(){
        return preis;
    }

    public int getJahr(){
        return jahr;
    }

    public int getFuellmenge(){
        return fuellmenge;
    }

    public int getGesamt(){
        return gesamtanzahl;
    }
}
