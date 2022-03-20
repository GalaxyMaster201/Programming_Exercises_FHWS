package de.fhws.programming_exercises.lesson_10.src.exercise1;

import java.util.Arrays;

public class Room{
    private final String roomName;
    private boolean occupied = false;
    private final int[] studentsInRoom;

    private int numberOfStudents = 0;
    private final int ABSENT = -1;

    // ----------CONSTRUCTORS---------- //

    /**
     * Constructor for the room object
     *
     * @param roomName  name of the room
     * @param maxNumber maximum number of students
     */
    public Room(String roomName, int maxNumber){
        this.roomName = roomName;
        this.studentsInRoom = new int[maxNumber];
        Arrays.fill(studentsInRoom, ABSENT);
    }


    // ----------GETTERS---------- //

    // getter for "occupied"
    public boolean isOccupied(){
        return occupied;
    }

    // getter for the current number of students
    public int getNumberOfStudents(){
        return numberOfStudents;
    }

    // getter for the room name
    public String getRoomName(){
        return roomName;
    }

    // getter for the array of students in a room
    public int[] getStudentsInRoom(){
        return studentsInRoom;
    }


    // ----------OTHER METHODS---------- //

    /**
     * A new student enters the room. The method checks if the student can be added.
     * If possible, add the student to the room array
     * @param student the number of the student which should be added
     */
    public void enterRoom(int student){
        if (roomFull()){        // room already full
            System.out.println("The room is already full, you cannot add another student");
        } else if (findIndex(student) != ABSENT){   // student already in room
            System.out.printf("The student %d is already in this room %n", student);
        } else{
            addStudent(student);
        }
        occupied = true;    // if student is in the room, that room is occupied
    }

    /**
     * This method adds a student to the room array and increments the counter
     * @param student the number of the student which should be removed
     */
    private void addStudent(int student){
        studentsInRoom[numberOfStudents] = student;
        numberOfStudents++;
    }

    /**
     * A student leaves the room. The method checks if student is even in the room.
     * If possible, remove the student from room array
     * @param student the number of student which should be removed
     */
    public void leaveRoom(int student){
        if (roomEmpty()){   // room empty, student is not in room
            System.out.println("The room is empty");
        } else if (findIndex(student) == ABSENT){   // student is not in room
            System.out.printf("The student %d is not in this room %n", student);
        } else{
            removeStudent(student);
            if (roomEmpty()){   //room empty, the room is no longer occupied
                occupied = false;
            }
        }
    }

    /**
     * This method removes a student from the room array, sorts the array again and decrements the counter
     * @param student the number of student which should be removed
     */
    private void removeStudent(int student){
        for (int i = findIndex(student); i < numberOfStudents-1; i++){      // shift values to the left
            studentsInRoom[i] = studentsInRoom[i+1];
        }
        numberOfStudents--;         // decrement the counter
        studentsInRoom[numberOfStudents] = ABSENT;          // set last value to ABSENT
    }

    /**
     * Finds the index of a specified student number
     * @param student student which should be found
     * @return either the index of that student or ABSENT (=-1)
     */
    private int findIndex(int student){
        for (int i = 0; i < studentsInRoom.length; i++){
            if (studentsInRoom[i] == student){
                return i;
            }
        }
        return ABSENT;
    }

    /**
     * Checks if the room is empty
     * @return boolean value saying if room is empty or not
     */
    private boolean roomEmpty(){
        return numberOfStudents == 0;
    }

    /**
     * Checks if the room is already full
     * @return boolean value saying if room is full or not
     */
    private boolean roomFull(){
        return numberOfStudents == studentsInRoom.length;
    }

    /**
     * Prints a list of students in the room to the terminal
     */
    public void printStudents(){
        System.out.printf("List of students in room %s: %n", roomName);     // HEADER
        if (numberOfStudents == 0){                                         // room empty
            System.out.println("The room is empty");
        } else{                                                         // room not empty
            StringBuilder output = new StringBuilder();
            for (int i = 0; i < numberOfStudents; i++){
                output.append(studentsInRoom[i]).append(", ");          // add student number and a comma to the output
            }
            output.deleteCharAt(output.length()-2);                     // remove the comma after last student
            System.out.print(output);                        // print list
            System.out.print("\n");
        }
    }

    /**
     * Clears the room array and resets the student counter
     */
    public void clearRoom(){
        Arrays.fill(studentsInRoom, ABSENT);
        numberOfStudents = 0;
    }

    /**
     * Fills the room array with placeholders and sets numberOfStudents to max value
     */
    public void fillWithIndex(){
        for (int i = 0; i < studentsInRoom.length; i++){
            studentsInRoom[i] = i;
        }
        numberOfStudents = studentsInRoom.length;
    }

}
