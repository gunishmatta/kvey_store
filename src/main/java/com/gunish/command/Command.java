package com.gunish.command;

import java.util.Map;

public interface Command {
        String execute(Map<String, String> store, String[] args);
}
