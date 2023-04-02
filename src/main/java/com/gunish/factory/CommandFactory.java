package com.gunish.factory;

import com.gunish.command.Command;
import com.gunish.command.GetCommand;
import com.gunish.command.PingCommand;
import com.gunish.command.PutCommand;
import com.gunish.command.RemoveCommand;

public class CommandFactory {
    public static Command serveCommand(String commandName)
    {
        return switch (commandName.toUpperCase()) {
            case "GET" -> new GetCommand();
            case "PUT" -> new PutCommand();
            case "REMOVE" -> new RemoveCommand();
            case "PING" -> new PingCommand();
            default -> throw new IllegalArgumentException("Unknown command: " + commandName);
        };
    }
}
