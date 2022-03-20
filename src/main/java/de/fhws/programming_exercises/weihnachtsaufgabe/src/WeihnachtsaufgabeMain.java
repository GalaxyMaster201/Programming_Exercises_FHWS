package de.fhws.programming_exercises.weihnachtsaufgabe.src;

import java.util.InputMismatchException;
import java.util.Scanner;

public class WeihnachtsaufgabeMain{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        willkommen(scanner);

        int[] berechnungszeitraum = frageBerechnungszeitraum(scanner);

        Anlage anlage = anlageauswahl(scanner, berechnungszeitraum);

        vermoegenEingeben(scanner, berechnungszeitraum);

        Rechner.ausgabe(anlage, berechnungszeitraum);

        //System.out.println(Arrays.toString(anlage.getRenditen()));
        scanner.close();
    }

    /**
     * Willkommensnachricht und Hinweis mit Bestätigung
     *
     * @param scanner Scanner
     */
    private static void willkommen(Scanner scanner){
        System.out.println("\nHerzlich willkommen bei Rendite-Verpasst-Rechner v1.2.31 von Matija Cabadaj!\n");
        System.out.println("""
                Wichtig: Es handelt sich nicht um eine Anlageberatung!
                Die hier modellierten Zusammenhänge könnten verkürzt oder gänzlich falsch sein!
                Ebenso besteht die Gefahr einer fehlerhaften Implementierung.""");
        System.out.print("Sind Sie damit einverstanden? [j]a - [n]ein \n-> ");
        if (scanner.next().toLowerCase().charAt(0) != 'j'){
            System.out.println("Es tut mir leid, aber Sie können nicht fortfahren.");
            System.exit(0);
        }
    }

    /**
     * Lässt den Nutzer einen Berechnungszeitraum zu eingeben und tauscht die 2 Jahreszahlen, falls notwendig.
     *
     * @param scanner Scanner
     * @return Ein Array aus 2 Jahreszahlen. Der Start mit Index [0], die Ende mit Index [1]
     */
    private static int[] frageBerechnungszeitraum(Scanner scanner){
        int[] berechnungszeitraum = new int[2];

        while (true){
            System.out.print("Ab welchem Jahr möchten Sie die Rendite berechnen? \n-> ");
            berechnungszeitraum[0] = scanner.nextInt();
            if (berechnungszeitraum[0] >= 1999 && berechnungszeitraum[0] <= 2021){
                break;
            } else{
                System.out.println("\nDie Rendite kann vor dem Jahr 1999 nicht berechnet werden!");
            }
        }

        while (true){
            System.out.print("Bis zu welchem Jahr möchten Sie die Rendite berechnen? \n-> ");
            berechnungszeitraum[1] = scanner.nextInt();
            if (berechnungszeitraum[1] >= 1999 && berechnungszeitraum[1] <= 2021){
                break;
            } else{
                System.out.println("\nDie Rendite kann für die Zukunft nicht berechnet werden!");
            }
        }
        return pruefeJahreseingabe(berechnungszeitraum);
    }

    /**
     * Prüft 2 Jahreszahlen und tauscht sie, sodass die erste Zahl kleiner als die zweite ist.
     *
     * @param berechnungszeitraum Array aus Jahreszahlen, die der Nutzer eingegeben hat
     * @return korrigiertes Array
     */
    private static int[] pruefeJahreseingabe(int[] berechnungszeitraum){
        if (berechnungszeitraum[1] < berechnungszeitraum[0]){
            int temp = berechnungszeitraum[1];
            berechnungszeitraum[1] = berechnungszeitraum[0];
            berechnungszeitraum[0] = temp;
            System.out.println("Ich habe die Werte für Sie umgetauscht :)");
        }
        return berechnungszeitraum;
    }

    /**
     * Lässt den Nutzer, sein Vermögen im Berechnungszeitraum einzugeben.
     *
     * @param scanner  Scanner
     * @param zeitraum Berechnungszeitraum
     */
    private static void vermoegenEingeben(Scanner scanner, int[] zeitraum){
        int[] vermoegen = new int[zeitraum[1]-zeitraum[0]+1];
        int[] zinsen = new int[vermoegen.length];

        /*
        die try-catch Blöcke sind da, um eine fehlerhafte Eingabe zu erkennen und dann
        die Eingabe zu wiederholen.
        */
        for (int i = 0; i <= zeitraum[1]-zeitraum[0]; i++){
            while (true){
                try{
                    System.out.printf("Geben Sie das Vermögen für das Jahr %d (mit Zinsen) in Euro ein %n-> ", i+zeitraum[0]);
                    vermoegen[i] = scanner.nextInt();
                    break;
                } catch (InputMismatchException e){
                    System.out.println("Ihre Eingabe ist ungültig, versuchen sie es erneut.");
                    scanner.nextLine();
                }
            }
            while (true){
                try{
                    System.out.printf("Geben Sie die Zinsen für das Jahr %d in Euro ein %n-> ", i+zeitraum[0]);
                    zinsen[i] = scanner.nextInt();
                    break;
                } catch (InputMismatchException e){
                    System.out.println("Ihre Eingabe ist ungültig, versuchen sie es erneut.");
                    scanner.nextLine();
                }
            }
            Rechner.setWerte(vermoegen, zinsen);
        }
    }

    /**
     * Lässt den Nutzer eine Anlage auszuwählen bzw. eine neue zu erstellen.
     *
     * @param scanner             Scanner
     * @param berechnungszeitraum der vom Nutzer eingegebene Berechnungszeitraum
     * @return die ausgewählte Anlage
     */
    private static Anlage anlageauswahl(Scanner scanner, int[] berechnungszeitraum){
        while (true){

            System.out.println("Wählen Sie eine Anlage aus:");
            System.out.println("[a] Anlage A \n[b] Anlage B \n[c] Anlage C \n[d] benutzerdefinierte Anlage");
            System.out.print("-> ");
            char c = scanner.next().charAt(0);
            if (c == 'a' || c == 'b' || c == 'c'){
                return new Anlage(c);
            } else if (c == 'd'){
                return new Anlage(scanner, berechnungszeitraum);
            } else{
                System.out.println("\nIhre Eingabe ist ungültig, versuchen Sie es erneut:");
            }
        }
    }
}

