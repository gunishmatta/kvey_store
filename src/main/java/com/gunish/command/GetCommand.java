package com.gunish.command;

import java.util.Map;

public class GetCommand implements Command {
    @Override
    public String execute(Map<String, String> store, String[] args) {
        String key = args[0];
        String value = store.get(key);
        return (value != null) ? value : "Key not found";
    }
}
