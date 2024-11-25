package com.aw.concurrency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class AdviceClient {

    public void receiver() {
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1", 4242);

            InputStreamReader stream = new InputStreamReader(socket.getInputStream());

            BufferedReader reader = new BufferedReader(stream);

            String advice =reader.readLine();

            System.out.println("Today you should" + advice);
            reader.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        AdviceClient adviceClient=new AdviceClient();

        adviceClient.receiver();


    }




}
