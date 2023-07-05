package org.command.executor.executors;

import org.command.executor.annotations.Param;
import org.command.executor.interfaces.ArgumentParser;
import org.command.executor.interfaces.ArgumentSetter;

import java.lang.reflect.Field;
import java.util.Map;

public class FieldArgumentsSetter implements ArgumentSetter {
    private static final ArgumentParser ARGUMENT_PARSER = new CommandLineArgumentParser();
    public void setArguments(Field[] fields, Map<String, String> arguments, Object instance) throws IllegalAccessException {
        for (Field field : fields) {
            Param paramAnnotation = field.getAnnotation(Param.class);
            String paramName = paramAnnotation.value();
            if (arguments.containsKey(paramName)) {
                Class<?> fieldType = field.getType();
                field.setAccessible(true);
                field.set(instance, ARGUMENT_PARSER.parseArgument(arguments.get(paramName), fieldType));
            }
        }
    }
}
