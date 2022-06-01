package de.fhws.programming_exercises.lesson_17.src.exercise_2;

import java.io.*;

public class FileCopier{

    /**
     * Copies a file from one location to another
     *
     * @param origin      current file location
     * @param destination file destination
     */
    public static void copyFile(File origin, File destination){
        try (FileInputStream fis = new FileInputStream(origin);
             FileOutputStream fos = new FileOutputStream(destination)
        ){
            copyStream(fis, fos);
        }catch (FileNotFoundException fnfe){    // file doesn't exist/couldn't be created
            System.out.println("A file could not be found");
            System.out.println(fnfe.getMessage());
        }catch (IOException ioe){
            System.out.println("IO Exception");
            System.out.println(ioe.getMessage());
        }
    }

    /**
     * Copies an InputStream into an OutputStream
     *
     * @param is InputStream to copy
     * @param os OutputStream to copy to
     * @throws IOException Stream already closed
     */
    private static void copyStream(InputStream is, OutputStream os) throws IOException{
        byte[] b = new byte[10];    // byte-array to store Stream Read results
        int n;                      // counter
        try{
            while (true){
                n = is.read(b);             // read 10 bytes
                if (n == -1) break;         // exit loop if end-of-file reached
                os.write(b, 0, n);      // write n bytes
            }
        }catch (IOException ioe){   // catches the Exception only to throw it again, but with different text ;)
            throw new IOException("IO Exception in copyStream Method");
        }

    }
}

