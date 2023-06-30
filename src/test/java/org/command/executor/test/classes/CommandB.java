package org.command.executor.test.classes;

import org.command.executor.annotations.Command;
import org.command.executor.annotations.Param;

@Command("CommandB")
public class CommandB implements Runnable {
    @Param("name")
    int number;
    @Override
    public void run() {

    }
    public void show() {
        System.out.println(number);
    }
}
