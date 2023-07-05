package org.command.executor.executors;

import org.command.executor.annotations.Command;
import org.command.executor.interfaces.CommandFinder;
import org.reflections.Reflections;

import java.net.URL;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class AnnotationCommandFinder implements CommandFinder {
    @Override
    public Set<Class<?>> findCommandMarkedClasses(String packageName) throws ClassNotFoundException {

        if (isPackageNotExists(packageName)) {
            throw new ClassNotFoundException();
        }

        Reflections reflections = new Reflections(packageName);
        Set<Class<?>> commandMarkedClasses = reflections.getTypesAnnotatedWith(Command.class);

        return commandMarkedClasses.stream()
                .filter(Runnable.class::isAssignableFrom)
                .collect(Collectors.toSet());
    }

    private static boolean isPackageNotExists(String packageName) {
        String packagePath = packageName.replace('.', '/');
        URL resource = ClassLoader.getSystemClassLoader().getResource(packagePath);
        return Objects.isNull(resource);
    }
}
