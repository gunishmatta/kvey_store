package com.gunish;

import com.gunish.command.Command;
import com.gunish.factory.CommandFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class KveyStore {

    private final Map<String, String> store;

    public KveyStore() {
        store = new HashMap<>();
    }

    public String processCommand(String input) {
        String[] parts = input.split(" ");
        String name = parts[0];
        String[] args = Arrays.copyOfRange(parts, 1, parts.length);
        System.out.println(Arrays.toString(args));
        Command command = CommandFactory.serveCommand(name);
        return command.execute(store, args);
    }

    public static void main(String[] args) throws IOException {
        KveyStore kveyStore=new KveyStore();
        ServerSocket serverSocket=new ServerSocket(1234);
        System.out.println("Listening on port 1234...");

        while (true)
        {
            Socket client=serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            String input = in.readLine();
            String response = kveyStore.processCommand(input);
            out.println(response);
            client.close();
        }

    }
}