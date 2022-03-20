package de.fhws.programming_exercises.lesson_10.src.exercise1;

public class Exercise1Main{
    public static void main(String[] args){
        System.out.println("START\n");
        Room room1 = new Room("H.1.2", 12);
        Room room2 = new Room("I.2.12", 25);

        addSomeStudents(room1, true, false, 5);     // add students to empty room
        room1.printStudents();
        addSomeStudents(room1, false, true, 5);     // try to add students to a full room
        room1.printStudents();
        removeSomeStudents(room1, false, 3);              // remove some students from the room
        room1.printStudents();
        removeAbsentStudent(room1);                                                         // try to remove a student who is not in the room
        room1.printStudents();
        addSomeStudents(room1, false, false, 2);    // add some students to the room
        room1.printStudents();
        removeSomeStudents(room1,false,15);
        room1.printStudents();
        addSomeStudents(room2,false,false,21);
        room2.printStudents();
        System.out.println("\nEND");
    }

    /**
     * Adds one or several students to the room list. The rooms can be emptied or filled using parameters.
     *
     * @param room                  the room to which students should be added
     * @param roomEmpty             empties the room and adds students
     * @param roomFull              fills the room with indexes/indices for testing
     * @param numberOfStudentsToAdd decides how many students should be added to the room
     */
    public static void addSomeStudents(Room room, boolean roomEmpty, boolean roomFull, int numberOfStudentsToAdd){
        if ((roomEmpty && roomFull) || numberOfStudentsToAdd < 0){
            throw new IllegalArgumentException("You just had to break it, didn't you?");
        } else if (roomFull){
            room.fillWithIndex();
        } else if (roomEmpty){
            room.clearRoom();
        }

        for (int i = 0; i < numberOfStudentsToAdd; i++){
            int studentNumber = (int) Math.round(Math.random() * Integer.MAX_VALUE-1);
            room.enterRoom(studentNumber);
        }
    }

    /**
     * Removes one or several students from the room list. The user can decide if a student should be absent
     *
     * @param room                     room from which students should be removed
     * @param roomEmpty                clear the room and try removing students
     * @param numberOfStudentsToRemove decides how many students should be removed from the room
     */
    public static void removeSomeStudents(Room room, boolean roomEmpty, int numberOfStudentsToRemove){
        int[] array = room.getStudentsInRoom();
        int numberOfStudents = room.getNumberOfStudents();
        int randomIndex;
        if (roomEmpty){
            room.clearRoom();
        } else{
            for (int i = 0; i < numberOfStudentsToRemove; i++){
                randomIndex = (int) (Math.random() * numberOfStudents);
                room.leaveRoom(array[randomIndex]);
            }
        }
    }

    /**
     * Tries to remove a student who is not in the room
     *
     * @param room  room from which a student should be removed
     */
    public static void removeAbsentStudent(Room room){
        room.leaveRoom(Integer.MAX_VALUE);
    }
}