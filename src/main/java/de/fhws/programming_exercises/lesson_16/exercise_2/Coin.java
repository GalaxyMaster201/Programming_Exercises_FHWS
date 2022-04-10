package de.fhws.programming_exercises.lesson_16.exercise_2;

/**
 * enum Coin erweitert um einen Konstruktor und um ein Attribut
 */
public enum Coin {

  CENT_1(1),
  CENT_2(2),
  CENT_5(5),
  CENT_10(10),
  CENT_20(20),
  CENT_50(50),
  EURO_1(100),
  EURO_2(200);

  final int value;

  Coin(int value)
  {
    this.value = value;
  }
}
