package com.gunish.command;

import java.util.Map;

public class PingCommand implements Command {
    @Override
    public String execute(Map<String, String> store, String[] args) {
        return "Pong";
    }
}
