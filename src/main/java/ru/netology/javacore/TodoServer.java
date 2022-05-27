package ru.netology.javacore;

import com.google.gson.Gson;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TodoServer {

    static class Require {

        String type, task;

        public Require(String type, String task) {
            this.type = type;
            this.task = task;
        }

        @Override
        public String toString() {
            return "type = '" + type + "', task = '" + task + "'";
        }
    }

    private final int port;
    private final Todos todos;

    public TodoServer(int port, Todos todos) {

        this.port = port;
        this.todos = todos;

    }

    public void start() {

        try (ServerSocket serverSocket = new ServerSocket(this.port)) {
            System.out.println("\nStarting server at " + this.port + "... \nServer started...\n");
            while (true) {
                try (
                        Socket clientSocket = serverSocket.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
                ) {
                    System.out.println("New connection accepted!");
                    System.out.println("Client address: " + clientSocket.getInetAddress() +
                            " , port: " + clientSocket.getPort());
                    String json = in.readLine();
                    System.out.println("Client message: " + json);
                    Require req = new Gson().fromJson(json, Require.class);
                    switch (req.type) {
                        case "ADD":
                            System.out.println("Add task '" + req.task + "' to TODO list");
                            todos.addTask(req.task);
                            break;
                        case "REMOVE":
                            System.out.println("Remove task '" + req.task + "' from TODO list");
                            todos.removeTask(req.task);
                            break;
                    }
                    System.out.println("Send TODO list to client... ");
                    out.println(todos.getTaskList());
                    System.out.println("Complete!\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Can't start server!");
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "TodoServer { " +
                " port = " + port +
                ", todos = " + todos +
                " } ";
    }
}
