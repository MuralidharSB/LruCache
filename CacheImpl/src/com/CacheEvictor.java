package com;

import java.util.LinkedHashMap;

import interfaces.EvictionCommand;

public class CacheEvictor<K, V> {
    private EvictionCommand<K, V> command;

    public void setCommand(EvictionCommand<K, V> command) {
        this.command = command;
    }

    public void execute(LinkedHashMap<K, V> map) {
        if (command != null) {
            command.evict(map);
        }
    }
}

