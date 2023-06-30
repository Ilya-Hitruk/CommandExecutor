package org.command.executor.executors;

import org.command.executor.test.classes.CommandA;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

class FieldArgumentsSetterTest {

    @Test
    void shouldSetArguments() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Object instance = CommandA.class.getDeclaredConstructor().newInstance();
        Field[] fields = instance.getClass().getDeclaredFields();

        Map<String, String> arguments = new HashMap<>(Map.of("name", "ilya"));

        new FieldArgumentsSetter().setArguments(fields, arguments, instance);

        Field nameField = fields[0];

        nameField.setAccessible(true);

        String nameValue = nameField.get(instance).toString();

        Assertions.assertEquals("ilya", nameValue);

    }
}