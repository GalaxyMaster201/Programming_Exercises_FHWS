package de.fhws.programming_exercises.lesson_09.src.exercise3;

public class Exercise3Main{
    public static void main(String[] args){
        Room room1 = new Room("I.2.1",30);
        Room room2 = new Room("I.2.12", 15);

        output(room1);              // first
        output(room2);              // output

        room1.setOccupied(true);    // set room I.2.1 to occupied
        System.out.println();       // spacer

        output(room1);              // second
        output(room2);              // output

    }

    /**
     * Displays whether the entered room is occupied or not
     * @param room the room which should be checked
     */
    public static void output(Room room){
        if(room.isOccupied()){      // room occupied
            System.out.printf("The room %s is occupied%n", room.getRoomName());
        }else {                     // room free
            System.out.printf("The room %s is not occupied%n", room.getRoomName());
        }
    }
}
