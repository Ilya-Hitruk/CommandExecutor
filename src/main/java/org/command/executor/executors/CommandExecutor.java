package org.command.executor.executors;

import org.command.executor.interfaces.ArgumentSetter;
import org.command.executor.interfaces.ClassFinder;
import org.command.executor.interfaces.CommandFinder;
import org.command.executor.warns.Warns;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Optional;
import java.util.Set;

public class CommandExecutor {

    private final static Logger logger = LoggerFactory.getLogger(CommandExecutor.class);
    private final static CommandFinder COMMAND_FINDER = new AnnotationCommandFinder();
    private final static ClassFinder CLASS_FINDER_BY_METHOD = new ClassFinderBySpecifiedMethod();
    private final static CommandLineParser COMMAND_LINE_PARSER = new CommandLineParser();
    private final static ArgumentSetter ARGUMENTS_SETTER = new FieldArgumentsSetter();


    public static void execute(String packageName, String[] args) {
        Set<Class<?>> commandMarkedClasses;
        CommandArguments arguments;
        Class<?> clazz;
        Object instance;

        try {
            commandMarkedClasses = COMMAND_FINDER.findCommandMarkedClasses(packageName);
        } catch (ClassNotFoundException e) {
            logger.warn(Warns.NO_SUCH_PACKAGE.getMessage());
            return;
        }

        try {
            arguments = COMMAND_LINE_PARSER.parseArgs(args);
        } catch (IllegalArgumentException e) {
            logger.warn(Warns.NOT_VALID_ARGUMENTS.getMessage());
            logger.info(Warns.TEMPLATE.getMessage());
            return;
        }

        Optional<Class<?>> optionalClass = CLASS_FINDER_BY_METHOD.findClass(commandMarkedClasses, arguments.getCommand());

        if (optionalClass.isPresent()) {
            clazz =  optionalClass.get();
        } else {
            logger.info(Warns.NO_DECLARED_METHOD.getMessage());
            return;
        }

        try {
            instance = clazz.getDeclaredConstructor().newInstance();
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            logger.warn(Warns.INVALID_OPERATION_WITH_CLASS.getMessage());
            return;
        }


        Field[] fields = clazz.getDeclaredFields();

        try {
            ARGUMENTS_SETTER.setArguments(fields, arguments.getArguments(), instance);
        } catch (IllegalAccessException e) {
            logger.warn(Warns.ARGUMENTS_CANT_BE_ACCESSED.getMessage());
            return;
        }

        try {
            Method method = clazz.getDeclaredMethod("run");
            method.invoke(instance);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            logger.warn(Warns.SPECIFIED_METHOD_CANT_BE_INVOKED.getMessage());
        }
    }
}