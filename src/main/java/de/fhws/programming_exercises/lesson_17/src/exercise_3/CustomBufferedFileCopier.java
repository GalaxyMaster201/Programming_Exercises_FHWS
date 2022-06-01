package de.fhws.programming_exercises.lesson_17.src.exercise_3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CustomBufferedFileCopier extends FileCopier{

    /**
     * Copies the file with a custom buffer of 1024 bytes
     *
     * @param fis FileInputStream
     * @param fos FileOutputStream
     * @throws IOException when something goes wrong during reading/writing
     */
    @Override
    protected void copyType(FileInputStream fis, FileOutputStream fos) throws IOException{
        System.out.println("-> Custom Buffered File Copier <-");
        byte[] b = new byte[1024];
        int n;
        while (true){
            n = fis.read(b);
            if (n == -1) break;     // if end-of-file is reached, break out of the loop
            fos.write(b, 0, n);
        }
    }
}
