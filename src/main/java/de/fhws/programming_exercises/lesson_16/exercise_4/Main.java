package de.fhws.programming_exercises.lesson_16.exercise_4;

public class Main{

    public static void main(String[] args){
        Human human = new Human();
        Robot robot = new Robot();
        Cyborg cyborg = new Cyborg();

        CarDanger danger = CarDanger.DANGER_FRONT;
        System.out.printf("Human reaction: %s \n", human.choose(danger).reaction);
        System.out.printf("Robot reaction: %s \n", robot.choose(danger).reaction);
        System.out.printf("Cyborg reaction: %s \n", cyborg.choose(danger).reaction);
    }
}
