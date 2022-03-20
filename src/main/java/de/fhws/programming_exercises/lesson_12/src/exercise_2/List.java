package de.fhws.programming_exercises.lesson_12.src.exercise_2;

public class List{
    private static final Person start = new Person("start", -1);       // starting point of the list, helps eliminate null-pointer exceptions
    // and removes the need for special checks to add someone to the list start
    // TODO - Get rid of the hardcoded start node

    public static void main(String[] args){
        insertPerson("Jameson", 30);
        insertPerson("Edwards", 25);
        insertPerson("Methi", 27);
        insertPerson("Metz", 62);
        insertPerson("Mayer", 19);

        printList();
    }

    /**
     * Inserts the person in the list, sorted by age in ascending order
     *
     * @param name name of the Person
     * @param age  age of the Person
     */
    private static void insertPerson(String name, int age){
        Person newPerson = new Person(name, age);
        Person cursor = start;

        while (cursor.next != null){
            if (cursor.next.getAge() < age){
                cursor = cursor.next;                           // move forward
            } else{                                             // add Person to the middle of the list
                cursor.next.previous = newPerson;               // resolve "right" connection
                newPerson.next = cursor.next;

                cursor.next = newPerson;                        // resolve "left" connection
                newPerson.previous = cursor;

                return;
            }
        }

        cursor.next = newPerson;       // add Person to the end of the list
        cursor.next.previous = cursor;
    }

    /**
     * Finds the Person object with the specified name
     *
     * @param name name of the person to find
     * @return the first Person object with the specified name
     */
    private static Person findPerson(String name){
        Person cursor = start.next;

        while (cursor != null){
            if (name.equals(cursor.getName())){
                return cursor;
            } else{
                cursor = cursor.next;
            }
        }
        return null;
    }

    /**
     * Prints the list forwards and then backwards in a new line
     */
    private static void printList(){
        Person cursor = start;

        while (cursor.next != null){        // print the list forwards
            System.out.printf("Name: %s, Age: %d \t\t", cursor.next.getName(), cursor.next.getAge());
            cursor = cursor.next;

        }

        System.out.println();

        while (cursor != start){            // print the list backwards
            System.out.printf("Name: %s, Age: %d \t\t", cursor.getName(), cursor.getAge());
            cursor = cursor.previous;
        }
    }
}
