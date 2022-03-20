package de.fhws.programming_exercises.lesson_02.src;

public class Aufgabe_2 {
    public static void main(String[] args){
        double p = 0;
        double q = 0;
        double D = Math.pow(p/2,2)-q; //die Diskriminante definieren
        if( D < 0){ //mit D prüfen, ob die Gleichung eine Lösung hat
            System.out.println("Die Gleichung hat keine Lösung ");
        }else{
            double res1;
            double res2;
            double sqrt = Math.sqrt(D);
            //Ergebnisse ausrechnen und runden
            res1 = (-p/2) + sqrt;
            res2 = (-p/2) - sqrt;
            if(res1 == res2){ //nur eine Lösung
                System.out.println("Die Lösung der Gleichung ist: "+Math.round((res1)*1000)/1000.0);
            }else{  //zwei Lösungen
                System.out.println("Die Lösungen der Gleichung sind: "+Math.round((res1)*1000)/1000.0+" und "+Math.round((res2)*1000)/1000.0);
            }
        }

    }
}
