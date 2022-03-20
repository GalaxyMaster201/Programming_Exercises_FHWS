package de.fhws.programming_exercises.other.uebungsaufgabe;

public class Main{

    Verwaltung verwaltung = new Verwaltung();

    public static void main(String[] args){
        Kaffeetasse k1 = new Kaffeetasse(150,1996,12.50);
        Kaffeetasse k2 = new Kaffeetasse(200,2015,20.00);
        Kaffeetasse k3 = new Kaffeetasse(250,2020,25.00);
        Kaffeetasse k4 = new Kaffeetasse(120,2002,16.75);
        Kaffeetasse k5 = new Kaffeetasse(300,2002,15.50);
    }

    private void printTassen(Kaffeetasse... kaffeetassen){
        Kaffeetasse[] sortiert = new Kaffeetasse[kaffeetassen.length];
        int index = 0;
        Kaffeetasse minTasse = kaffeetassen[0];

        for(Kaffeetasse tasse : kaffeetassen){
            if (tasse == null){
                continue;
            }
            if (tasse.getFuellmenge() <= minTasse.getFuellmenge()){
                minTasse = tasse;
                sortiert[index] = minTasse;
                index++;
            }
        }
        for(Kaffeetasse tasse : sortiert){
            System.out.println(tasse.getFuellmenge()+", "+ tasse.getJahr()+ " ," +tasse.getPreis());
        }
    }


    private void printAnzahl(){
        System.out.println("Anzahl der ausgegebenen Tassen: "+verwaltung.getZaehler());
    }

    private void printAusgeliehen(){
        if(verwaltung.getStart() == null){
            System.out.println("Es wurden keine Tassen ausgegebenen :(");
            return;
        }

        Kaffeetasse temp = verwaltung.getStart();

        System.out.println("Liste der ausgegebenen Tassen:");

        while(temp != null){
            System.out.println(temp.getFuellmenge()+", "+temp.getJahr()+", "+temp.getPreis());
            temp = temp.next;
        }
    }
}
