package de.fhws.programming_exercises.lesson_17.src.exercise_3;


import java.util.Scanner;

public class Main{
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        Timer timer = new Timer();

        UnbufferedFileCopier uc = new UnbufferedFileCopier();
        BufferedFileCopier bc = new BufferedFileCopier();
        CustomBufferedFileCopier cbc = new CustomBufferedFileCopier();

        System.out.println("Enter the path to the file you want to copy: ");
        String origin = scanner.nextLine();
        System.out.println("Enter the path for the new file");
        String destination = scanner.nextLine();
        scanner.close();

        System.out.println();

        timer.start();
        uc.copy(origin, destination, "uc_copy");                   // copy file using an unbuffered copier
        System.out.printf("Elapsed time: %d ms \n\n", timer.end());

        timer.start();
        bc.copy(origin, destination, "bc_copy");                   // copy file using standard buffered copier
        System.out.printf("Elapsed time: %d ms \n\n", timer.end());

        timer.start();
        cbc.copy(origin, destination, "cbc_copy");                // copy file using custom 1024 byte copier
        System.out.printf("Elapsed time: %d ms \n\n", timer.end());

        System.out.println("Terminating program...");
    }


}
