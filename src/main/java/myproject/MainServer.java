package myproject;


import myproject.basic.commands.ICommand;
import myproject.basic.general.Bank;
import myproject.basic.helper.Bootstrap;
import myproject.basic.helper.Helper;

import java.net.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class MainServer {

    Bank bank;
    Map<String, ICommand> commands;

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public MainServer() {
        this.bank = new Bank();
        Bootstrap bootstrap = new Bootstrap();
        this.commands = bootstrap.createCommandMap();
    }


    public void start(int port) {

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server: " + serverSocket);

            clientSocket = serverSocket.accept();
            System.out.println("Client: " + clientSocket);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));


            while (true) {

                out.println("Please enter a command.");
                String input = Helper.requestCommandServerEdition(in);
                System.out.println(input);

                if (input != null) {

                    if ("q".equals(input)) break;

                    ICommand cmd = commands.get(input.toLowerCase());

                    if (cmd != null) {

                        Map<String, Object> params = null;
                        if (cmd.info() != "") {
                            out.println(cmd.info());
                            params = Helper.requestParamsServerEdition(bank, out, in);
                        } else {
                            params = new HashMap<>();
                            params.put("bank", bank);
                            params.put("out", out);
                        }


                        try {
                            cmd.execute(params);

                        } catch (Exception e) {
                            e.printStackTrace();
                            out.println("The command could not be executed successfully.");
                        }

                    } else {
                        out.println("Bad command: " + input);
                    }
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            stop();
        }
    }

    public void stop() {
        try {
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MainServer server = new MainServer();
        server.start(4444);
    }
}