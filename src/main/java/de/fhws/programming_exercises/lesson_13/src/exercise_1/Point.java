package de.fhws.programming_exercises.lesson_13.src.exercise_1;

public class Point{
    private final double a;
    private final double b;
    private final double c;

    public Point(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Calculates the distance of the point from the origin
     * @return distance
     */
    public double calculateDistance(){
        double distance;
        distance = Math.sqrt((a * a)+(b * b)+(c * c));
        return distance;
    }

    @Override
    public String toString(){
        return "a = "+a+", b = "+b+", c = "+c;
    }
}
