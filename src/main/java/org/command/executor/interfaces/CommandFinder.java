package org.command.executor.interfaces;

import java.util.Set;

public interface CommandFinder {
    Set<Class<?>> findCommandMarkedClasses(String packageName) throws ClassNotFoundException;
}
