package org.command.executor.executors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CommandLineArgumentParserTest {

    @Test
    void shouldParseString() {
        String expected = "value";
        Assertions.assertEquals(expected, new CommandLineArgumentParser().parseArgument("value", String.class));
    }

    @Test
    void shouldParseInt() {
        int expected = 100;
        Assertions.assertEquals(expected, new CommandLineArgumentParser().parseArgument(String.valueOf(100), int.class));
    }

    @Test
    void shouldParseDouble() {
        double expected = 100.1;
        Assertions.assertEquals(expected, new CommandLineArgumentParser().parseArgument(String.valueOf(100.1), double.class));
    }

    @Test
    void shouldParseBoolean() {
        boolean expected = true;
        Assertions.assertEquals(expected, new CommandLineArgumentParser().parseArgument(String.valueOf(true), boolean.class));
    }
}