package org.command.executor.interfaces;

import java.util.Optional;
import java.util.Set;

public interface ClassFinder {
    Optional<Class<?>> findClass(Set<Class<?>> classes, String commandName);
}
