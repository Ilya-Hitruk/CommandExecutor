package org.command.executor.executors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.Map;


class CommandLineParserTest {

    @Test
    void shouldParseArgs() {
        String[] args = {"print", "--arg1", "value1", "--arg2", "value2",};
        String commandName = "print";
        Map<String, String> argsMap = Map.of("arg1", "value1", "arg2", "value2");

        CommandArguments expected = new CommandArguments(commandName, argsMap);
        CommandArguments actual = new CommandLineParser().parseArgs(args);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldThrowException() {
        String[] args = {"print", "--arg1", "value1", "--arg2"};
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CommandLineParser().parseArgs(args));
    }
}