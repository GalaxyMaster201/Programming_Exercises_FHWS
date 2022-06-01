package de.fhws.programming_exercises.lesson_19.src.exercise_1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ObjectServer extends ObjectTCPMember implements Runnable{

    private final int PORT;
    private ServerSocket serverSocket;
    private Socket connToClient;

    public ObjectServer(int port){
        super("SERVER");
        this.PORT = port;
    }

    public static void main(String[] args){
        ObjectServer objectServer = new ObjectServer(5000);

        objectServer.run();
    }

    public boolean isRunning(){
        return running.get();
    }

    /**
     * When an object implementing interface {@code Runnable} is used
     * to create a thread, starting the thread causes the object's
     * {@code run} method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method {@code run} is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run(){
        running.set(true);

        initialize();

        System.out.println("SERVER - connection to client established");
        Object incoming = null;

        writeMessage("Press Y to start a game of Hangman");
        while (incoming == null                                             // --------------------------------
                || incoming.getClass() != Message.class                     // wait for user to start the game
                || !"Y".equalsIgnoreCase(((Message) incoming).msgText))     // --------------------------------
        {
            incoming = readObject();
        }

        ObjectHangman objectHangman = new ObjectHangman();      // create the game
        writeAnswer(objectHangman.guess((char) 0));             // get initial values

        while (running.get() && !objectHangman.finished){

            incoming = readObject();                            // read received Object

            if (incoming.getClass() == Guess.class){                                // if Object is a Guess
                writeAnswer(objectHangman.guess(((Guess) incoming).character));     // pass to objectHangman
            }
            if (incoming.getClass() == Message.class                                // if object is a Message
                    && "--stop".equals(((Message) incoming).msgText))               // check if Server is supposed to stop
            {
                writeMessage("--stop");
                close();
            }

        }
    }

    /**
     * Write the Answer received from {@code ObjectHangman} to the ObjectOutputStream
     *
     * @param answer the received answer
     */
    private void writeAnswer(Answer answer){
        try{
            oos.writeObject(answer);
        }catch (IOException e){
            System.err.println("SERVER - COULD NOT SEND ANSWER!");
            fail(e);
        }
    }

    /**
     * Initializes the Streams and Socket
     */
    private void initialize(){
        try{
            this.serverSocket = new ServerSocket(PORT);
        }catch (IOException e){
            System.err.println("SERVER - COULD NOT CREATE A SERVER SOCKET!");
            fail(e);
        }
        try{
            this.connToClient = serverSocket.accept();
        }catch (IOException e){
            System.err.println("SERVER - COULD NOT ESTABLISH CONNECTION TO CLIENT!");
            fail(e);
        }
        try{
            this.oos = new ObjectOutputStream(connToClient.getOutputStream());
        }catch (IOException e){
            System.err.println("SERVER - COULD NOT CREATE A WRITER!");
        }
        try{
            this.ois = new ObjectInputStream(connToClient.getInputStream());
        }catch (IOException e){
            System.err.println("SERVER - COULD NOT CREATE A READER!");
            fail(e);
        }
    }

    /**
     * Closes the I/O Streams and the Sockets
     */
    public void close(){
        System.out.println("SERVER - stopping");
        try{
            if (ois != null) ois.close();
            if (oos != null) oos.close();
            if (connToClient != null) connToClient.close();
            if (serverSocket != null) serverSocket.close();
            running.set(false);
            System.out.println("SERVER - stopped");
        }catch (IOException e){
            System.err.println("SERVER - COULD NOT BE CLOSED!");
            e.printStackTrace();
        }

    }

}
