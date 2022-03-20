package de.fhws.programming_exercises.other.uebungsaufgabe;

public class Kaffeetasse{
    private int fuellmenge;
    private int jahr;
    private double preis;
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
