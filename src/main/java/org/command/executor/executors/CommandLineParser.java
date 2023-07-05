package org.command.executor.executors;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CommandLineParser {
    private final static int COMMAND_INDEX = 0;
    private final static int ARGUMENTS_INDEX = 1;

    public CommandArguments parseArgs(String[] args) throws IllegalArgumentException {
        String commandName = args[COMMAND_INDEX];
        String[] arguments = Arrays.copyOfRange(args, ARGUMENTS_INDEX, args.length);
        Map<String, String> mapOfArgumentsAndValues = new HashMap<>();

        if (arguments.length % 2 != 0) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < args.length; i += 2) {
            if (i + 1 < arguments.length) {
                String key = arguments[i].replaceAll("-", "");
                String value = arguments[i + 1];

                mapOfArgumentsAndValues.put(key, value);
            }
        }

        return new CommandArguments(commandName, mapOfArgumentsAndValues);
    }
}
