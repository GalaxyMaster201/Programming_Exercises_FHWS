package de.fhws.programming_exercises.lesson_17.src.exercise_3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class UnbufferedFileCopier extends FileCopier{

    /**
     * Copies a file byte by byte
     *
     * @param fis FileInputStream
     * @param fos FileOutputStream
     * @throws IOException when something goes wrong during reading/writing
     */
    @Override
    protected void copyType(FileInputStream fis, FileOutputStream fos) throws IOException{
        System.out.println("-> Unbuffered File Copier <-");
        while (true){
            int b = fis.read();
            if (b == -1) break;     // if end-of-file is reached, break out of the loop
            fos.write(b);
        }
    }
}
