package org.command.executor.executors;

import org.command.executor.test.classes.CommandA;
import org.command.executor.test.classes.CommandB;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

class AnnotationCommandFinderTest {

    @Test
    void shouldFindCommandMarkedAndImplementedRunnableClasses() throws ClassNotFoundException {

        Set<Class<?>> expected = Set.of(CommandA.class, CommandB.class);

        Assertions.assertEquals(expected, new AnnotationCommandFinder().findCommandMarkedClasses("org.command.executor.test.classes"));
    }

    @Test
    void shouldThrowException() {
        Assertions.assertThrows(ClassNotFoundException.class, () -> new AnnotationCommandFinder().findCommandMarkedClasses("gadfsgdfa"));
    }

}