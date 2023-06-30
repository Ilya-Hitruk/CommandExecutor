package org.command.executor.interfaces;

import java.lang.reflect.Field;
import java.util.Map;

public interface ArgumentSetter {
    void setArguments(Field[] fields, Map<String, String> arguments, Object instance) throws IllegalAccessException;
}
