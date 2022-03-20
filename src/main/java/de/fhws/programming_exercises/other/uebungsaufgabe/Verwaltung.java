package de.fhws.programming_exercises.other.uebungsaufgabe;

public class Verwaltung{
    private Kaffeetasse start;
    private Kaffeetasse temp;
    private Kaffeetasse oldtemp;

    private int zaehler = 0;

    public void ausleihen(Kaffeetasse kt){

        if (start == null){
            start = kt;
            zaehler++;
            return;
        }

        while(temp != null){
            if(kt == temp){
                System.out.println("Diese Tasse wurde schon ausgeliehen");
                return;
            } else {
                oldtemp = temp;
                temp = temp.next;
            }
        }

        if (kt.getPreis() < start.getPreis()){
            kt.next = start;
            start = kt;
            zaehler++;
            return;
        }

        temp = start.next;
        oldtemp = start;

        while(temp != null){
            if(kt.getPreis() < temp.getPreis()){
                kt.next = temp;
                oldtemp.next = kt;
                zaehler++;
                return;
            } else {
                oldtemp = temp;
                temp = temp.next;
            }
        }

        oldtemp.next = kt;
        zaehler++;
    }

    public void zurueckgeben(Kaffeetasse kt){
        if(start == null){
            System.out.println("Es wurden noch keine Tassen ausgeliehen.");
            return;
        }

        temp = start.next;
        oldtemp = start;

        if (start == kt){
            start = start.next;
            zaehler--;
            return;
        }

        while(temp != null){
            if(temp == kt){
                oldtemp.next = temp.next;
                kt.next = null;
                zaehler--;
                return;
            } else {
                oldtemp = temp;
                temp = temp.next;
            }
        }
        System.out.println("Ihre Tasse wurde noch nicht ausgeliehen");
    }

    public Kaffeetasse getStart(){
        return start;
    }

    public int getZaehler(){
        return zaehler;
    }
}





















