package de.fhws.programming_exercises.lesson_17.src.exercise_3;

import java.io.*;

public class BufferedFileCopier extends FileCopier{

    /**
     * Copies a file using the built-in BufferedStream
     *
     * @param fis FileInputStream
     * @param fos FileOutputStream
     * @throws IOException when something goes wrong during reading/writing
     */
    @Override
    protected void copyType(FileInputStream fis, FileOutputStream fos) throws IOException{
        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        System.out.println("-> Standard Buffered File Copier <-");
        while (true){
            int n = bis.read();

            if (n == -1){
                bos.flush();
                break;     // if end-of-file is reached, break out of the loop
            }

            bos.write(n);
        }

    }
}
