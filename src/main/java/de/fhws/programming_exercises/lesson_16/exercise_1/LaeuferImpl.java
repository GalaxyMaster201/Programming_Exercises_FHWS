package de.fhws.programming_exercises.lesson_16.exercise_1;

public class LaeuferImpl extends AbstractFigur implements Laeufer
{
  public LaeuferImpl(int x, int y)
  {
    super(x, y);
  }

  /**
   * Der läufer kann sich diagonal bewegen.
   * Die erlaubten Felder werden mit der formel "y_neu = y +- (x-x_neu)" berechnet
   * @return alle Felder, auf welche sich der Läufer aus der jetzigen Position bewegen kann.
   */
  public Brett gibErlaubteFelder()
  {
    Brett brett = new Brett();
    for (int i = 1; i <= 8; i++){
      int delta = Math.abs(x-i);
      if (y-delta >= 1){
        brett.markiereFeld(i, y-delta);
      }
      if (y+delta <= 8){
        brett.markiereFeld(i, y+delta);
      }

    }

    return brett;
  }
  
  public static void main(String[] args)
  {
    LaeuferImpl l = new LaeuferImpl(4,5);
    Brett brett = l.gibErlaubteFelder();
    for (int j = 1; j <= 8; j++)
    {
      for (int i = 1; i <= 8; i++)
      {
        if (brett.gibFeld(i, j)) System.out.print("x");
        else System.out.print("o");
      }
      System.out.println();
    }
  }
}
