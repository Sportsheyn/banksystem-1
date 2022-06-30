package myproject.basic.helper;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class EchoClient {

    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void startConnection(String ip, int port) {
        try {
            clientSocket = new Socket(ip, port);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String sendMessage(String msg) {
        try {
            out.println(msg);
            return in.readLine();
        } catch (Exception e) {
            return null;
        }
    }

    public void stopConnection() {
        try {
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        EchoClient client;
        client = new EchoClient();
        client.startConnection("127.0.0.1", 4444); //127.0.0.1 //104.155.127.193

        Scanner scanner = new Scanner(System.in);

        System.out.println(client.in.readLine());

        while (true) {

            String line;
            while(client.in.ready() && (line = client.in.readLine()) != null) {
                System.out.println(line);
            }

            String input = scanner.nextLine();

            if (input.equals("out")) {
                break;
            } else {
                String response = client.sendMessage(input);
                System.out.println(response);
            }
        }

        client.stopConnection();

    }

}