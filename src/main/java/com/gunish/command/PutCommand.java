package com.gunish.command;

import java.util.Map;

public class PutCommand implements Command {
    @Override
    public String execute(Map<String, String> store, String[] args) {
        String key = args[0];
        String value = args[1];
        store.put(key, value);
        return "OK";
    }
}
