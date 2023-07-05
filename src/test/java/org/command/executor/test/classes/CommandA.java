package org.command.executor.test.classes;

import org.command.executor.annotations.Command;
import org.command.executor.annotations.Param;

@Command("CommandA")
public class CommandA implements Runnable {
    @Param("name")
    String name;
    @Override
    public void run() {

    }
    public void print() {
        System.out.println(name);
    }
}
