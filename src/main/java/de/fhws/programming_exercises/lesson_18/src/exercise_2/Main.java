package de.fhws.programming_exercises.lesson_18.src.exercise_2;

public class Main{
    public static void main(String[] args){
        final String host = "localhost";
        final int port = 5000;

        Server objectServer = new Server(port);
        Client objectClient = new Client(host, port);

        Thread serverThread = new Thread(objectServer, "Server thread");           // create Server and Client on
        Thread clientThread = new Thread(objectClient, "Client thread");     // separate Threads


        serverThread.start();               // start the Server
        if (objectServer.isRunning()){            // makes sure that the Server is started before the Client
            clientThread.start();           // start the Client
        }


    }
}
