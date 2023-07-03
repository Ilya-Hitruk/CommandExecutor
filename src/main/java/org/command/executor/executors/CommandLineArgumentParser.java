package org.command.executor.executors;

import org.command.executor.interfaces.ArgumentParser;

public class CommandLineArgumentParser implements ArgumentParser {
    public Object parseArgument(String value, Class<?> targetType) {
        if (targetType.equals(int.class) || targetType.equals(Integer.class)) {
            return Integer.parseInt(value);
        } else if (targetType.equals(double.class) || targetType.equals(Double.class)) {
            return Double.parseDouble(value);
        } else if (targetType.equals(boolean.class) || targetType.equals(Boolean.class)) {
            return Boolean.parseBoolean(value);
        }
        return value;       // for String
    }
}
