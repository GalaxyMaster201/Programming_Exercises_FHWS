package de.fhws.programming_exercises.lesson_19.src.exercise_1;

public class Main{
    public static void main(String[] args){
        final String host = "localhost";
        final int port = 5000;

        ObjectServer server = new ObjectServer(port);
        ObjectClient client = new ObjectClient(host, port);

        Thread serverThread = new Thread(server, "Server thread");       // create Server and Client on
        Thread clientThread = new Thread(client, "Client thread");      // separate Threads


        serverThread.start();               // start the Server
        if (server.isRunning()){            // makes sure that the Server is started before the Client
            clientThread.start();           // start the Client
        }


    }
}
