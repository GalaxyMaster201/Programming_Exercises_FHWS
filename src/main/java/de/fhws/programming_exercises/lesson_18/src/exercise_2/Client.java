package de.fhws.programming_exercises.lesson_18.src.exercise_2;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client extends TCPMember implements Runnable{

    private final String HOST;
    private final int PORT;

    private Socket connToServer;

    public Client(String host, int port){
        super("CLIENT");
        HOST = host;
        PORT = port;
    }

    public static void main(String[] args){
        Client objectClient = new Client("localhost", 5000);

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
        String inMsg;
        String outMsg;
//        inMsg = readLine();

        while (running.get()){
            inMsg = readLine();
            if ("--stop".equals(inMsg)){
                close();
            }
            if (inMsg.charAt(0) != '-'){
                System.out.println(inMsg);
            }
            outMsg = scanner.next();
            writeLine(outMsg);

        }
    }


    private void initialize(){
        try{
            this.connToServer = new Socket(HOST, PORT);
        }catch (IOException e){
            System.err.println("CLIENT - COULD NOT ESTABLISH CONNECTION TO SERVER!");
            fail(e);
        }
        try{
            this.br = new BufferedReader(new InputStreamReader(connToServer.getInputStream(), StandardCharsets.UTF_8));
        }catch (IOException e){
            System.err.println("CLIENT - COULD NOT CREATE A READER!");
            fail(e);
        }
        try{
            this.bw = new BufferedWriter(new OutputStreamWriter(connToServer.getOutputStream(), StandardCharsets.UTF_8));
        }catch (IOException e){
            System.err.println("COULD NOT CREATE A WRITER!");
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
            if (bw != null) bw.close();
            if (br != null) br.close();
            if (connToServer != null) connToServer.close();
            running.set(false);
            System.out.println("CLIENT - stopped");
        }catch (IOException e){
            System.err.println("CLIENT - COULD NOT BE CLOSED!");
            e.printStackTrace();
        }
    }
}
