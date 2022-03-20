package de.fhws.programming_exercises.weihnachtsaufgabe.src;

public class Rechner{

    private static int[] vermoegenMit;
    private static int[] zinsenArr;
    private static int[] vermoegenOhne;

    public static int[] getVermoegenMit(){
        return vermoegenMit;
    }

    public static int[] getZinsenArr(){
        return zinsenArr;
    }


    public static void setWerte(int[] vermoegenMit, int[] zinsenArr){
        Rechner.vermoegenMit = vermoegenMit;
        Rechner.zinsenArr = zinsenArr;
    }

    /**
     * Berechnet die notwendigen Werte und gibt sie in ein einer Tabellenform zurück
     * @param anlage die ausgewählte Anlage
     * @param zeitraum der Berechnungszeitraum
     */
    public static void ausgabe(Anlage anlage, int[] zeitraum){
        zinsenReinigen();

        // Kopf der Tabelle
        System.out.println("Jahr: \t\t Zu/Abflüsse: \t\t Sparbuch: \t\t Kapitalmarkt: \t\t Unterschied:");
        System.out.println("----- \t\t------------- \t\t -------- \t\t ------------ \t\t --------------");

        // Ausgabe der einzelnen Zeilen
        for (int jahr = zeitraum[0]; jahr <= zeitraum[1]; jahr++){
            int index = jahr-zeitraum[0];

            String delta = deltaBerechnen(index);                           // Unterschied zum Jahr davor
            int sparbuch = vermoegenMit[index];                             // Vermögen mit Zinsen
            int marktwert = kapitalmarktWert(jahr,index,anlage);            // alternatives Vermögen mit einer Anlage
            String unterschied = sparMarktUnterschied(sparbuch,marktwert);  // Unterschied zwischen dem Sparbuchvermögen und dem Marktwert

            // formatierte Ausgabe
            System.out.printf("%4d \t\t %6s \t\t\t  %5d \t\t\t %5d \t\t %17s %n",
                    jahr,delta, sparbuch, marktwert,unterschied);
        }

    }

    /**
     * subtrahiert die Zinsen vom Sparbuchvermögen um "saubere" Werte zu erhalten
     */
    private static void zinsenReinigen(){
        vermoegenOhne = new int[vermoegenMit.length];
        for (int i = 0; i < vermoegenMit.length; i++){
            vermoegenOhne[i] = vermoegenMit[i]-zinsenArr[i];
        }
    }

    /**
     * Berechnet den Unterschied im "sauberen" Vermögen zum Vorjahr
     * @param index index in dem vermoegenOhne Array
     * @return Unterschied zum Vorjahr
     */
    private static String deltaBerechnen(int index){
        String str = "\t";
        if (index > 0){
            int delta = vermoegenOhne[index]-vermoegenOhne[index-1];
            if (delta >= 0){
                str = "+"+delta;
            } else{
                str = ""+delta;
            }
        }
        return str;
    }

    /**
     * Berechnet das alternative Vermögen, wenn man das Geld in eine Anlage investiert hätte
     * @param jahr um welchen Jahr es geht
     * @param index index in dem vermoegenOhne Array
     * @param anlage ausgewählte Anlage
     * @return Kapitalmarktwert der Anlage
     */
    private static int kapitalmarktWert(int jahr,int index, Anlage anlage){
        double aktuelleRendite = anlage.getRendite(jahr)/100;
        return (int) Math.round(vermoegenOhne[index] + (vermoegenOhne[index] * aktuelleRendite));
    }

    /**
     * Berechnet den Unterschied zwischen dem Vermögen auf dem Sparbuch und dem Marktwert der Anlage
     * @param sparbuch Vermögen mit Sparzinsen
     * @param marktwert Vermögen mit Anlage
     * @return Unterschied zwischen den Werten
     */
    private static String sparMarktUnterschied(int sparbuch, int marktwert){
        int unterschiedZahl = marktwert - sparbuch;

        double unterschiedProzent = ((1d*unterschiedZahl)/ Math.min(marktwert,sparbuch))*100d;
        unterschiedProzent = Math.round(unterschiedProzent*100d)/100d;      // auf 2 Stellen gerundet

        String ausgabe;

        if(unterschiedZahl >= 0){   // Gewinn
            ausgabe = "+"+unterschiedZahl+" (+"+unterschiedProzent+"%)";
        }else {                     // Verlust
            ausgabe = ""+unterschiedZahl+" ("+unterschiedProzent+"%)";
        }
        return ausgabe;
    }
}
