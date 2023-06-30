package org.marked;

import org.command.executor.annotations.Command;
import org.command.executor.annotations.Param;

@Command("Driver")
public class Driver implements Runnable {

    @Param("name")
    private String name;

    @Param("licenceId")
    private int licenceId;

    @Override
    public void run() {
        printInfo();
    }

    public void printInfo() {
        System.out.println(name + " " + licenceId);
    }

}
