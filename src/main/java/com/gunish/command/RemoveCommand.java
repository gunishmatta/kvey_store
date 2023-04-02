package com.gunish.command;

import java.util.Map;

public class RemoveCommand implements Command {
    @Override
    public String execute(Map<String, String> store, String[] args) {
        String key = args[0];
        store.remove(key);
        return "OK";
    }
}
