package org.command.executor.interfaces;

public interface ArgumentParser {
    Object parseArgument(String value, Class<?> targetType);
}
