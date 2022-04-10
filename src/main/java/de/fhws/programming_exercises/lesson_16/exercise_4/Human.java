package de.fhws.programming_exercises.lesson_16.exercise_4;

public class Human extends AbstractBeing
    implements Driving{

    @Override
    public CarDangerReaction choose(CarDanger danger){
        boolean unsure = Math.random() * 4 < 1;

        return unsure ?
                CarDangerReaction.UNDECIDED :
                switch (danger){
                    case DANGER_LEFT -> CarDangerReaction.GO_RIGHT;
                    case DANGER_RIGHT -> CarDangerReaction.GO_LEFT;
                    case DANGER_FRONT -> CarDangerReaction.BRAKE;
                };
    }
}
