package de.fhws.programming_exercises.lesson_17.src.exercise_4;

import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamDoubler implements AutoCloseable{
    OutputStream os1;
    OutputStream os2;

    public OutputStreamDoubler(OutputStream os1, OutputStream os2){
        this.os1 = os1;
        this.os2 = os2;
    }

    @Override
    public void close() throws IOException{
        os1.close();
        os2.close();
    }

    /**
     * Writes one byte to two Streams
     *
     * @param b byte to write
     * @throws IOException one of the streams is closed
     */
    public void write(int b) throws IOException{
        boolean failed = false;
        try{
            os1.write(b);
        }catch (IOException ioException){
            failed = true;
        }
        try{
            os2.write(b);
        }catch (IOException ioException){
            failed = true;
        }

        if (failed){
            throw new IOException("IO Exception! One of the streams is closed");
        }

    }

}
