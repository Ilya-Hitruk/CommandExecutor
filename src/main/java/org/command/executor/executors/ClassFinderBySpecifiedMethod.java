package org.command.executor.executors;

import org.command.executor.annotations.Command;
import org.command.executor.interfaces.ClassFinder;

import java.util.Optional;
import java.util.Set;

public class ClassFinderBySpecifiedMethod implements ClassFinder {
    @Override
    public Optional<Class<?>> findClass(Set<Class<?>> classes, String commandName) {
        for (Class<?> clazz : classes) {
            Command command = clazz.getAnnotation(Command.class);
            if (command.value().equals(commandName)) {
                return Optional.of(clazz);
            }
        }
        return Optional.empty();
    }
}