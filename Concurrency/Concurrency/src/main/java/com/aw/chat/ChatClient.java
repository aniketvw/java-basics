package com.aw.chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {


    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 5000);

        PrintWriter writer = new PrintWriter(socket.getOutputStream());

        System.out.println("Connected");

        while (true) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Message");
            String message = scanner.nextLine();

            writer.println(message);

            System.out.println("");


        }

    }


}
