package org.command.executor.executors;

import org.command.executor.annotations.Command;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;

import java.util.Set;

class ClassFinderBySpecifiedMethodTest {

    @Test
    void shouldFindClassByMethod() {
        String commandName = "print";
        Reflections reflections = new Reflections("org.command.executor.test.classes");
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(Command.class);

        Assertions.assertTrue(new ClassFinderBySpecifiedMethod().findClass(classes, commandName).isPresent());
    }

    @Test
    void shouldReturnOptionalEmptyIfNoSuchClass() {
        String commandName = "someMethod";
        Reflections reflections = new Reflections("org.command.executor.test.classes");
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(Command.class);

        Assertions.assertFalse(new ClassFinderBySpecifiedMethod().findClass(classes, commandName).isPresent());
    }
}