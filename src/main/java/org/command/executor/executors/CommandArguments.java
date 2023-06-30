package org.command.executor.executors;

import java.util.Map;
import java.util.Objects;

public class CommandArguments {
    private final String command;

    private final Map<String, String> arguments;

    public CommandArguments(String command, Map<String, String> arguments) {
        this.command = command;
        this.arguments = arguments;
    }

    public String getCommand() {
        return command;
    }

    public Map<String, String> getArguments() {
        return arguments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommandArguments arguments1)) return false;
        return Objects.equals(command, arguments1.command) && Objects.equals(arguments, arguments1.arguments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(command, arguments);
    }
}


