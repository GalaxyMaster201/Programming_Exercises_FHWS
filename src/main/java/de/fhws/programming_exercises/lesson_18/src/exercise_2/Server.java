package de.fhws.programming_exercises.lesson_18.src.exercise_2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Server extends TCPMember implements Runnable{

    private final int PORT;
    private ServerSocket serverSocket;
    private Socket connToClient;

    public Server(int port){
        super("SERVER");
        this.PORT = port;
    }

    public static void main(String[] args){
        Server objectServer = new Server(5000);

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
        String inMsg = "";

        writeLine("Press Y to start a game of Hangman");
        while (!"Y".equalsIgnoreCase(inMsg)){
            inMsg = readLine();
        }

        Hangman hangman = new Hangman();
        hangmanRequest(hangman, inMsg);

        while (running.get()){
            if (hangman.finished){
                writeLine("Congratulations, you won");
            }else{
                inMsg = readLine();
                hangmanRequest(hangman, inMsg);
            }
            if ("--stop".equals(inMsg)){
                writeLine("--stop");
                close();
            }


        }
    }

    private void hangmanRequest(Hangman hangman, String inMsg){
        writeLine("Enter the next character: " + hangman.getGuess());
        while (inMsg == null){
            inMsg = readLine();
        }
        if (inMsg.length() >= 1) hangman.guess(inMsg.charAt(0));
    }

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
            System.err.println("SERVER - COULD NOT ESTABLISH CONNECTION TO SERVER!");
            fail(e);
        }
        try{
            this.br = new BufferedReader(new InputStreamReader(connToClient.getInputStream(), StandardCharsets.UTF_8));
        }catch (IOException e){
            System.err.println("SERVER - COULD NOT CREATE A READER!");
            fail(e);
        }
        try{
            this.bw = new BufferedWriter(new OutputStreamWriter(connToClient.getOutputStream(), StandardCharsets.UTF_8));
        }catch (IOException e){
            System.err.println("SERVER - COULD NOT CREATE A WRITER!");
        }
    }

    /**
     * Closes the I/O Streams and the Sockets
     */
    public void close(){
        System.out.println("SERVER - stopping");
        try{
            if (bw != null) bw.close();
            if (br != null) br.close();
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
