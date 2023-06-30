package org.command.executor.executors;

import org.command.executor.interfaces.ClassFinder;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;
import java.util.Set;

public class ClassFinderBySpecifiedMethod implements ClassFinder {
    public Optional<Class<?>> findClass(Set<Class<?>> classes, String commandName) {
        for (Class<?> clazz : classes) {
            Method[] methods = clazz.getDeclaredMethods();
            if (isMethodPresents(methods, commandName)) {
                return Optional.of(clazz);
            }
        }
        return Optional.empty();
    }

    private boolean isMethodPresents(Method[] methods, String commandName) {
        long i = Arrays.stream(methods).filter(method -> method.getName().equals(commandName)).count();
        return i > 0;
    }
}

