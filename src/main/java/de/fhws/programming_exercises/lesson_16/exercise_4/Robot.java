package de.fhws.programming_exercises.lesson_16.exercise_4;

public class Robot extends AbstractBeing
        implements Driving{

    @Override
    public CarDangerReaction choose(CarDanger danger){
        return switch (danger){
            case DANGER_LEFT -> CarDangerReaction.GO_RIGHT;
            case DANGER_RIGHT -> CarDangerReaction.GO_LEFT;
            case DANGER_FRONT -> CarDangerReaction.BRAKE;
        };
    }
}
