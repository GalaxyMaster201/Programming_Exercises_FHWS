package de.fhws.programming_exercises.lesson_09.src.exercise3;

public class Room{
    private final String roomName;
    private final int maxNumber;
    private boolean occupied = false;

    /**
     * Constructor for the room object
     * @param roomName  name of the room
     * @param maxNumber maximum number of students
     */
    public Room(String roomName, int maxNumber){
         this.roomName = roomName;
         this.maxNumber = maxNumber;
    }

    // ----------GETTERS & SETTERS----------

    // getter & setter for "occupied"
    public void setOccupied(boolean occupied){
        this.occupied = occupied;
    }
    public boolean isOccupied(){
        return occupied;
    }

    // getter for the room name
    public String getRoomName(){
        return roomName;
    }

    // getter for the max number of students
    public int getMaxNumber(){
        return maxNumber;
    }
    // ----------------------------------------

}
