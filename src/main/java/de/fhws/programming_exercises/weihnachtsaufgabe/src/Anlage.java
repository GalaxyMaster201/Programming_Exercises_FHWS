package de.fhws.programming_exercises.weihnachtsaufgabe.src;

import java.util.Scanner;

public class Anlage{

    private double[] renditen;
    private int vonJahr = 1999;
    private int bisJahr = 2021;

    /**
     * Konstruktor der eine der 3 Vorlagen erstellt
     *
     * @param c Bezeichnung der Anlage
     */
    public Anlage(char c){
        switch (c){
            case 'a':
                renditen = new double[]{18.48, 1.12, 6.69, 4.59, 1.27, -2.95, 34.93, 11.41, 17.79, 8.09,
                        24.69, 37.67, 15.35, 3.66, -30.84, 13.07, -1.24, 12.73, -1.45, 3.47, 21.25, 13.39, 3.63};
                break;
            case 'b':
                renditen = new double[]{39.10, -7.54, -19.79, -43.94, 37.08, 7.34, 27.07, 21.98, 22.29, -40.37,
                        23.85, 16.06, -14.69, 29.06, 25.48, 2.65, 9.56, 6.87, 12.51, -18.26, 25.48, 3.55, 11.09};
                break;
            case 'c':
                renditen = new double[]{44.74, -8.23, -13.36, -33.01, 8.83, 4.71, 23.94, 5.51, -3.41, -39.08,
                        23.03, 17.16, -4.53, 11.44, 18.74, 17.21, 8.33, 8.47, 5.51, -5.92, 27.49, 4.64, 26.67};
                break;
        }
    }

    /**
     * Konstruktor für eine benutzerdefinierte Anlage
     *
     * @param scanner             Scanner
     * @param berechnungszeitraum Ein Array aus 2 Jahreszahlen
     */
    public Anlage(Scanner scanner, int[] berechnungszeitraum){
        this.vonJahr = berechnungszeitraum[0];
        this.bisJahr = berechnungszeitraum[1];
        renditen = new double[(bisJahr-vonJahr)+1];
        for (int i = vonJahr; i <= bisJahr; i++){
            System.out.printf("Geben Sie die Rendite für das Jahr %d ohne Prozent-Zeichen ein: \n-> ", i);
            setRendite(i, scanner.nextFloat());
        }
    }

    public double[] getRenditen(){
        return renditen;
    }

    public int getVonJahr(){
        return vonJahr;
    }

    public int getBisJahr(){
        return bisJahr;
    }

    public double getRendite(int jahr){
        return renditen[jahr-vonJahr];
    }

    public void setRendite(int jahr, float wert){
        renditen[jahr-vonJahr] = wert;
    }


}


