package de.fhws.programming_exercises.lesson_19.src.exercise_1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ObjectClient extends ObjectTCPMember implements Runnable{

    private final String HOST;
    private final int PORT;

    private Socket connToServer;

    public ObjectClient(String host, int port){
        super("CLIENT");
        HOST = host;
        PORT = port;
    }

    public static void main(String[] args){
        ObjectClient objectClient = new ObjectClient("localhost", 5000);

        objectClient.run();
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
        Scanner scanner = new Scanner(System.in);

        running.set(true);

        initialize();

        System.out.println("CLIENT - connection to server established");
        Object incoming;
        while (running.get()){

            incoming = readObject();

            if (incoming instanceof Message){
                String msgText = ((Message) incoming).msgText;
                if ("--stop".equals(msgText)){
                    close();
                }
                if ('-' != msgText.charAt(0)){
                    System.out.println(msgText);
                }
            }else if (incoming instanceof Answer answer){
                System.out.println(answer);
            }

            System.out.print("Next character: ");
            String text = scanner.next();

            if ((text.charAt(0) == '-' && text.charAt(1) == '-') || incoming instanceof Message){
                writeMessage(text);
            }else{
                writeGuess(text.charAt(0));
            }

        }
    }

    /**
     * Write a guess to ObjectOutputStream
     *
     * @param c character to pass to objectHangman
     */
    private void writeGuess(char c){
        try{
            oos.writeObject(new Guess(c));
            oos.flush();
        }catch (IOException e){
            System.err.println("CLIENT - COULD NOT WRITE GUESS!");
            fail(e);
        }
    }

    /**
     * Initializes the Streams and Socket
     */
    private void initialize(){
        try{
            this.connToServer = new Socket(HOST, PORT);
        }catch (IOException e){
            System.err.println("CLIENT - COULD NOT ESTABLISH CONNECTION TO SERVER!");
            fail(e);
        }
        try{
            this.oos = new ObjectOutputStream(connToServer.getOutputStream());
        }catch (IOException e){
            System.err.println("CLIENT - COULD NOT CREATE A WRITER!");
        }
        try{
            this.ois = new ObjectInputStream(connToServer.getInputStream());
        }catch (IOException e){
            System.err.println("CLIENT - COULD NOT CREATE A READER!");
            fail(e);
        }
    }


    /**
     * Closes the Streams and Socket
     */
    @Override
    public void close(){
        System.out.println("CLIENT - stopping");
        try{
            if (ois != null) ois.close();
            if (oos != null) oos.close();
            if (connToServer != null) connToServer.close();
            running.set(false);
            System.out.println("CLIENT - stopped");
        }catch (IOException e){
            System.err.println("CLIENT - COULD NOT BE CLOSED!");
            e.printStackTrace();
        }
    }
}
