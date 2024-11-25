package com.aw.concurrency;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class AdviceServer {

    String[] adviceList={"“Take smaller bites","Go for the tight jeans. No they do NOT\n" +
            "make you look fat","One word: inappropriate"};

    public void go(){

        try {
            ServerSocket serverSocket=new ServerSocket(4242);

            while (true){
                Socket socket= serverSocket.accept();//the accept method blocks (just sits there) until arequest comes in, and then the method returns aSocket (on some anonymous port) for communicatingwith the client

                PrintWriter writer=new PrintWriter(socket.getOutputStream());
                String advice=getAdvice();
                writer.println(advice);
                writer.close();
                System.out.println(advice);

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private String getAdvice() {
        int random = (int) (Math.random() * adviceList.length);
        return adviceList[random];
    }

    public static void main(String[] args) {
        AdviceServer server=new AdviceServer();
        server.go();
    }

}
