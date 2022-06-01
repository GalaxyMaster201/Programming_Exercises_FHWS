package de.fhws.programming_exercises.lesson_17.src.exercise_3;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public abstract class FileCopier extends FileChecker{

    /**
     * Copies a file from one location to another
     *
     * @param origin      current location of the file
     * @param destination location for the copy
     */
    protected void copy(String origin, String destination, String suffix){

        destination = reformatName(destination, suffix);

        // check if the file paths are valid
        if (!checkInputs(origin, destination)){
            return;
        }

        // create the IO-Streams and start copying
        try (FileInputStream fis = new FileInputStream(origin);
             FileOutputStream fos = new FileOutputStream(destination)){

            copyType(fis, fos);


        }catch (IOException ioe){
            System.out.println("IO Exception!");
            return;
        }

        // check if files are equal
        checkIfEqual(origin, destination);
    }

    /**
     * Allows for further refinement of the way the file is copied
     *
     * @param fis FileInputStream
     * @param fos FileOutputStream
     * @throws IOException when something goes wrong during reading/writing
     */
    protected abstract void copyType(FileInputStream fis, FileOutputStream fos) throws IOException;

    /**
     * Checks if two files are equal to see if the operation was successful
     *
     * @param origin      location of original file
     * @param destination location of copy
     */
    protected void checkIfEqual(String origin, String destination){
        if (!compareFiles(origin, destination)){
            System.out.println("Copy operation failed, please try again :(");
        }else{
            System.out.println("Copy operation successful :)");
        }
    }

    private String reformatName(String path, String suffix){
        String[] strings = path.split("\\.");
        int len = strings.length;
        return strings[len - 2] + "_" + suffix + "." + strings[len - 1];
    }
}
