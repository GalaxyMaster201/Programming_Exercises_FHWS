package de.fhws.programming_exercises.lesson_17.src.exercise_3;

import java.io.File;
import java.util.Scanner;

public class FileChecker{


    /**
     * Checks the file paths obtained from user
     *
     * @param origin      current location of file
     * @param destination location for the new copy
     * @return true if the inputs are valid
     */
    boolean checkInputs(String origin, String destination){

        // check if the paths are valid
        if (!(checkPath(origin) && checkPath(destination))){
            return false;
        }

        // check if the origin file exists
        if (checkFile(origin) == -1){
            System.out.println("The file " + origin + " does not exist!");
            return false;
        }

        // check if the destination file already exists.
        // if that is the case, ask for permission to overwrite it
        if (checkFile(destination) != -1){
            if (!askOverwritePermission()){
                System.out.println("Permission denied, terminating program");
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the file is at the given location and checks its size
     *
     * @param location location of the file to check
     * @return size of File in Bytes or -1 if file not found
     */
    private long checkFile(String location){
        try{
            File file = new File(location);

            return file.isFile()        // if file exists,
                    ? file.length()     // return its length,
                    : -1;               // else return -1

        }catch (NullPointerException npe){
            return -1;
        }
    }

    /**
     * Asks the user if they want to overwrite an existing file
     *
     * @return
     */
    private boolean askOverwritePermission(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("The file already exists. Do you want to overwrite it? Y/N");
        String answer = scanner.nextLine();

        return answer.toUpperCase().charAt(0) == 'Y';
    }

    /**
     * Checks if the path given by the user is valid
     *
     * @param path path to check
     * @return true if path valid
     */
    private boolean checkPath(String path){
        if (path.indexOf('\\') != -1){
            path = convertPath(path);
        }
        return checkPathStart(path) && checkPathEnd(path);
    }

    /**
     * Switches the backslash ( \ ) from the Windows path format to the universal forward slash ( / )
     *
     * @param path path to convert
     * @return path with / instead of \
     */
    private String convertPath(String path){
        return path.replace('\\', '/');
    }

    /**
     * Checks if the path has the correct starting format of [driveLetter]://
     *
     * @param path path to check
     * @return true if path start valid
     */
    private boolean checkPathStart(String path){
        String start = path.substring(0, 3);                      // gets start of path e.g "C://"
        if (start.charAt(0) > 'A' && start.charAt(0) < 'Z'){
            if (":/".equals(start.substring(1))){
                return true;
            }
        }
        System.out.println("Invalid start of path: " + path);
        return false;
    }

    /**
     * Checks if the path end COULD be a file, meaning it has a file extension
     *
     * @param path path to check
     * @return true if text after last / contains a .
     */
    private boolean checkPathEnd(String path){

        String sub = path.substring(path.lastIndexOf('/'));     // get last part of path

        if (sub.lastIndexOf('.') == -1){                        // check if last part contains a .
            System.out.println("Invalid end of path: " + path);
            return false;
        }
        return true;
    }

    /**
     * Compares the sizes of two files
     *
     * @param path1 path of the first file
     * @param path2 path of the second file
     * @return true if files are of equal size
     */
    public boolean compareFiles(String path1, String path2){
        long l1 = new File(path1).length();
        long l2 = new File(path2).length();
        return l1 == l2;
    }
}
