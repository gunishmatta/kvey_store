package com.gunish.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class KveyStoreClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 1234);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        out.println("PING");
        String response = in.readLine();
        System.out.println("PING response: " + response);

        out.println("PUT foo bar");
        response = in.readLine();
        System.out.println("PUT response: " + response);

        out.println("GET foo");
        response = in.readLine();
        System.out.println("GET response: " + response);

        out.println("REMOVE foo");
        response = in.readLine();
        System.out.println("REMOVE response: " + response);

        socket.close();
    }
}
