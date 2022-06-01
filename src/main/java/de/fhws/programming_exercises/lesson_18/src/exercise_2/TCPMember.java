package de.fhws.programming_exercises.lesson_18.src.exercise_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class TCPMember{
    protected final String type;

    protected AtomicBoolean running = new AtomicBoolean(true);

    protected BufferedReader br;
    protected BufferedWriter bw;

    protected TCPMember(String type){
        this.type = type;
    }


    protected abstract void close();

    /**
     * Reads a line from the InputStream
     *
     * @return line from InputStream, {@code null} if end-of-file reached
     */
    protected String readLine(){
        String inMsg = null;
        try{
            inMsg = br.readLine();
        }catch (IOException e){
            System.err.println(type + " - READ FAILED!");
            fail(e);
        }
        return inMsg;
    }

    /**
     * Writes a line to the OutputStream, adding a {@code \n} to the end
     *
     * @param outMsg message to write
     */
    protected void writeLine(String outMsg){
        try{
            bw.write(outMsg + "\n");
            bw.flush();
        }catch (IOException e){
            System.err.println(type + " - WRITE FAILED!");
            fail(e);
        }
    }

    /**
     * Shuts down the Server and throws the exception to {@code System.err}
     *
     * @param e Exception which has been thrown
     */
    protected void fail(Exception e){
        close();
        e.printStackTrace();
    }
}
