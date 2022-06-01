package de.fhws.programming_exercises.lesson_19.src.exercise_1;

import java.io.*;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class ObjectTCPMember{
    protected final String type;

    protected AtomicBoolean running = new AtomicBoolean(true);

    /**
     * @deprecated
     */
    protected BufferedReader br;
    /**
     * @deprecated
     */
    protected BufferedWriter bw;

    protected ObjectOutputStream oos;
    protected ObjectInputStream ois;

    protected ObjectTCPMember(String type){
        this.type = type;
    }


    protected abstract void close();

    /**
     * Reads a line from the InputStream
     *
     * @return line from InputStream, {@code null} if end-of-file reached
     *
     * @deprecated not applicable to Objects
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
     * Reads an object from the ObjectInputStream
     *
     * @return read Object
     */
    protected Object readObject(){
        try{
            return ois.readObject();
        }catch (IOException | ClassNotFoundException e){
            System.err.println(type + " - WRITE FAILED!");
            fail(e);
            return null;
        }
    }

    /**
     * Writes a line to the OutputStream, adding a {@code \n} to the end
     *
     * @param outMsg message to write
     * @deprecated not applicable to Objects
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
     * Writes a Message Object to the ObjectOutputStream
     *
     * @param text message text to send
     */
    protected void writeMessage(String text){
        try{
            oos.writeObject(new Message(text));
            oos.flush();
        }catch (IOException e){
            System.err.println(type + " - WRITE FAILED!");
            fail(e);
        }
    }

    /**
     * Shuts down the Server and throws the exception stack trace to {@code System.err}
     *
     * @param e Exception which has been thrown
     */
    protected void fail(Exception e){
        close();
        e.printStackTrace();
    }
}
